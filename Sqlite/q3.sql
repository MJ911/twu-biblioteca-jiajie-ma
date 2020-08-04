SELECT * FROM book
WHERE book.id NOT IN (
	SELECT checkout_item.book_id FROM checkout_item
	WHERE checkout_item.book_id IS NOT NULL
)
UNION
SELECT * FROM movie
WHERE movie.id NOT IN (
	SELECT checkout_item.movie_id FROM checkout_item
	WHERE checkout_item.movie_id IS NOT NULL
)