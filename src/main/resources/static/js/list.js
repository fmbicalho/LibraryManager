//list.js
document.addEventListener('DOMContentLoaded', () => {
    const bookList = document.getElementById('book-list');

    /**
     * Fetches the list of books from the API and populates the book list.
     * Creates card elements for each book and appends them to the book list.
     */
    const fetchBooks = () => {
        fetch('http://localhost:8085/api/books')
            .then(response => response.json())
            .then(data => {
                bookList.innerHTML = '';
                data.forEach(book => {
                    const col = document.createElement('div');
                    col.className = 'col-md-2 col-sm-4'; // 5 columns per row

                    const card = document.createElement('div');
                    card.className = 'card';
                    card.style = 'width: 100%;';
                    card.innerHTML = `
                        <img src="/images/book.png" class="card-img-top" alt="Book Image">
                        <div class="card-body">
                            <h5 class="card-title">${book.title}</h5>
                            <p class="card-text">by ${book.author}</p>
                            <div class="btn-group">
                                <a href="/books/${book.id}" class="btn btn-primary">View</a>
                                <a href="/books/${book.id}/edit" class="btn btn-secondary">Edit</a>
                                <button class="btn btn-danger" onclick="deleteBook(${book.id})">Delete</button>
                            </div>
                        </div>
                    `;
                    col.appendChild(card);
                    bookList.appendChild(col);
                });
            })
            .catch(error => console.error('Error:', error));
    };

    /**
     * Deletes a book by its ID after user confirmation.
     * Refreshes the book list after successful deletion.
     * @param {number} id - The ID of the book to delete.
     */
    window.deleteBook = (id) => {
        if (confirm('Are you sure you want to delete this book?')) {
            fetch(`http://localhost:8085/api/books/${id}`, {
                method: 'DELETE'
            })
                .then(() => fetchBooks())
                .catch(error => console.error('Error:', error));
        }
    };

    fetchBooks();
});
