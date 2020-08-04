SELECT member.name FROM member 
WHERE member.id in (
	SELECT checkout_item.member_id from checkout_item, book
	WHERE book.id = checkout_item.book_id AND book.title = "The Hobbit"
)