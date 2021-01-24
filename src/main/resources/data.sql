INSERT INTO user (id, name, email) VALUES
  (1, 'Aliko', 'Dangote@yopmail.com'),
  (2, 'Bill', 'Gates@yopmail.com'),
  (3, 'Folrunsho', 'Alakija@yopmail.com');

INSERT INTO feature (id, name) VALUES
  (1, 'Home'),
  (2, 'Role'),
  (3, 'Setting');

INSERT INTO user_feature (id, user_id, feature_id, access) VALUES
  (1, 1, 1, 1),
  (2, 1, 2, 1),
  (3, 1, 3, 1),
  (4, 2, 1, 1),
  (5, 2, 2, 1),
  (6, 2, 3, 1),
  (7, 3, 1, 1),
  (8, 3, 2, 1),
  (9, 3, 3, 1);