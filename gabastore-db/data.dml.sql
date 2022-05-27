/*
 * DML = Data Manipulation Language
 * Command lines from 'gabastore-db' folder:
 * psql -h localhost -p 5432 -U postgres -d gabastore
 * \i data.dml.sql
 * \q
 */

DELETE FROM users;
DELETE FROM roles;
DELETE FROM categories;
DELETE FROM products;

 INSERT INTO roles(name) VALUES ('admin');
 
 INSERT INTO users (username, password) VALUES
    ('user@mail.com', '$2a$12$vrT8/vYBdK5ze/vo6s7LXer5q0mBWQk3tJVsR0iLgEe4OIsdhuc1u' );
    
    
INSERT INTO users (username, password, role_id) VALUES ('admin@mail.com', '$2a$12$iSUb5ik.sSg8Jy8hlRBESuFHlbF6FydELVKJSkYVTvnjQcg6e8A56', (SELECT r.id FROM roles r WHERE r.name = 'admin'));
	



INSERT INTO categories(name) VALUES ('protein'),('vitamines'),('beauty');

INSERT INTO products(name, description,price, image_url, category_id) VALUES ('Vitamine','Lors des périodes intenses, le stress peut parfois prendre le dessus et avoir des effets négatifs : vous pouvez vous sentir fatigué, excédé, moins performant au travail.

Stress Resist comprimé bicouche a été développé pour répondre aux besoins de l’organisme en période de stress grâce à la libération en deux temps de ses ingrédients.

Sa libération en 2 temps permet une meilleure assimilation de ses ingrédients et agit tout au long de la journée.

Stress Resist comprimé bicouche contient notamment de l’extrait de Rhodiola Rosea pour la résistance au stress et de l’extrait de thé vert pour favoriser la relaxation.

N’attendez pas que le stress prenne le dessus. Prenez un comprimé de Stress Resist.','19.90','assets/IMG/vitamines/placeholder.png',(SELECT c.id FROM categories c WHERE c.name = 'vitamines'));

INSERT INTO products(name, description,price, image_url, category_id) VALUES ('Proteine','Lors des périodes intenses, le stress peut parfois prendre le dessus et avoir des effets négatifs : vous pouvez vous sentir fatigué, excédé, moins performant au travail.

Stress Resist comprimé bicouche a été développé pour répondre aux besoins de l’organisme en période de stress grâce à la libération en deux temps de ses ingrédients.

Sa libération en 2 temps permet une meilleure assimilation de ses ingrédients et agit tout au long de la journée.

Stress Resist comprimé bicouche contient notamment de l’extrait de Rhodiola Rosea pour la résistance au stress et de l’extrait de thé vert pour favoriser la relaxation.

N’attendez pas que le stress prenne le dessus. Prenez un comprimé de Stress Resist.','15.99','assets/IMG/vitamines/placeholder.png',(SELECT c.id FROM categories c WHERE c.name = 'protein'));

INSERT INTO products(name, description,price, image_url, category_id) VALUES ('Beauté','Lors des périodes intenses, le stress peut parfois prendre le dessus et avoir des effets négatifs : vous pouvez vous sentir fatigué, excédé, moins performant au travail.

Stress Resist comprimé bicouche a été développé pour répondre aux besoins de l’organisme en période de stress grâce à la libération en deux temps de ses ingrédients.

Sa libération en 2 temps permet une meilleure assimilation de ses ingrédients et agit tout au long de la journée.

Stress Resist comprimé bicouche contient notamment de l’extrait de Rhodiola Rosea pour la résistance au stress et de l’extrait de thé vert pour favoriser la relaxation.

N’attendez pas que le stress prenne le dessus. Prenez un comprimé de Stress Resist.','17.95','assets/IMG/vitamines/placeholder.png',(SELECT c.id FROM categories c WHERE c.name = 'beauty'));
