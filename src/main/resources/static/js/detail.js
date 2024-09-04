//detail.js
document.addEventListener('DOMContentLoaded', () => {
    const path = window.location.pathname;
    const bookId = path.split('/').pop();
    console.log('Book ID:', bookId);

    /**
     * Validates the book ID from the URL path.
     * Redirects to the book list if the book ID is invalid.
     */
    if (!bookId || isNaN(bookId)) {
        console.error('Invalid book ID:', bookId);
        alert('Invalid book ID. Redirecting to the book list.');
        window.location.href = '/books';
        return;
    }

    /**
     * Fetches book details from the API and populates the page.
     * Displays the book details or 'N/A' if data is missing.
     * Sets the edit link for the book.
     */
    fetch(`http://localhost:8085/api/books/${bookId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Book not found');
            }
            return response.json();
        })
        .then(data => {
            console.log('Book Data:', data);
            document.getElementById('book-title').textContent = data.title || 'N/A';
            document.getElementById('book-author').textContent = data.author || 'N/A';
            document.getElementById('book-isbn').textContent = data.isbn || 'N/A';
            document.getElementById('book-publishedDate').textContent = data.publishedDate || 'N/A';
            document.getElementById('book-price').textContent = data.price || 'N/A';
            document.getElementById('book-description').textContent = data.description || 'N/A';

            document.getElementById('edit-book').href = `/books/${bookId}/edit`;
        })
        .catch(error => {
            console.error('Error fetching book:', error);
            alert('Book not found.');
            window.location.href = '/books';
        });

    /**
     * Handles the click event to delete the book.
     * Confirms with the user and sends a DELETE request to the API.
     * Redirects to the book list upon successful deletion.
     */
    document.getElementById('delete-book').addEventListener('click', () => {
        if (confirm('Are you sure you want to delete this book?')) {
            fetch(`http://localhost:8085/api/books/${bookId}`, {
                method: 'DELETE'
            })
                .then(response => {
                    if (response.ok) {
                        window.location.href = '/books';
                    } else {
                        throw new Error('Failed to delete book');
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert('Error deleting book.');
                });
        }
    });
});