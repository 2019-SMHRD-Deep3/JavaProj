SELECT b.b_title, b.b_author, b.b_isbn, p.p_publisher, g.g_genre
FROM book b, publisher p, genre g
WHERE b.b_isbn = p.b_isbn AND g.b_isbn = b.b_isbn;