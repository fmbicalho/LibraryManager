// add-edit.js
document.addEventListener('DOMContentLoaded', () => {
    const path = window.location.pathname;
    const segments = path.split('/');
    const isEditing = segments.includes('edit');
    const bookId = isEditing ? segments[segments.length - 2] : null;
    const formTitle = document.getElementById('form-title');
    const bookForm = document.getElementById('book-form');
    const titleInput = document.getElementById('title');
    const authorInput = document.getElementById('author');
    const isbnInput = document.getElementById('isbn');
    const publishedDateInput = document.getElementById('publishedDate');
    const priceInput = document.getElementById('price');
    const descriptionInput = document.getElementById('description');

    /**
     * Fetches book details if editing mode is enabled and populates the form.
     * Updates the form title to 'Edit Book' if in editing mode, otherwise 'Add Book'.
     */
    if (isEditing && bookId) {
        fetch(`/api/books/${bookId}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                titleInput.value = data.title;
                authorInput.value = data.author;
                isbnInput.value = data.isbn;
                publishedDateInput.value = data.publishedDate;
                priceInput.value = data.price;
                descriptionInput.value = data.description;
                formTitle.textContent = 'Edit Book';
            })
            .catch(error => {
                console.error('Error fetching book:', error);
                alert('Error fetching book data.');
            });
    } else {
        formTitle.textContent = 'Add Book';
    }

    /**
     * Handles the form submission for adding or updating a book.
     * Sends a POST request if adding a new book, or a PUT request if editing an existing book.
     * Redirects to the book list on successful save or shows an error message.
     *
     * @param {Event} event - The submit event
     */
    bookForm.addEventListener('submit', (event) => {
        event.preventDefault();

        const method = isEditing ? 'PUT' : 'POST';
        const url = isEditing ? `/api/books/${bookId}` : '/api/books';

        fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                title: titleInput.value,
                author: authorInput.value,
                isbn: isbnInput.value,
                publishedDate: publishedDateInput.value,
                price: priceInput.value,
                description: descriptionInput.value
            })
        })
            .then(response => {
                if (response.ok) {
                    window.alert("The book has been saved successfully!");
                    window.location.href = '/books';
                } else {
                    return response.text().then(text => {
                        throw new Error(text || 'Failed to save book.');
                    });
                }
            })
            .catch(error => {
                console.error('Error saving book:', error);
                alert('Error saving book: ' + error.message);
            });
    });

    /**
     * Handles the cancel button click to redirect back to the book list.
     */
    document.getElementById('cancel').addEventListener('click', () => {
        window.location.href = '/books';
    });
});