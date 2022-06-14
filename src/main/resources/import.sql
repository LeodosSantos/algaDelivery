insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Goumert', 10,1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.5 ,1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 2);
insert into restaurante (nome, taxa_frete, cozinha_id) values('thaYFood', 5.5, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Lion', 6.6, 2);

insert into forma_pagamento(id, nome) value (1,'dinheiro')
insert into forma_pagamento(id, nome) value (2,'debido')
insert into forma_pagamento(id, nome) value (3,'credito')
insert into forma_pagamento(id, nome) value (4,'pix')

insert into permissao(id, nome, descricao) value (1,'baixa', 'Apenas consulta')
insert into permissao(id, nome, descricao) value (2,'media', 'consulta e venda')
insert into permissao(id, nome, descricao) value (3,'alta', 'consulta venda e cancelamentos')

insert into estado (id, nome) values (1, 'Sao Paulo');
insert into estado (id, nome) values (2, 'Rio de Janeiro');

insert into cidade (nome, estado_id) values ('Uba',1);
insert into cidade (nome, estado_id) values ('Sao Paulo', 1);
insert into cidade (nome, estado_id) values ('Petropolis', 2);
insert into cidade (nome, estado_id) values('Rio de Janeiro', 2);


