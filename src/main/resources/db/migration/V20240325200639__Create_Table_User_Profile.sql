CREATE TABLE IF NOT EXISTS user_profile (
    id SERIAL PRIMARY KEY,
    user_id BIGINT,
    profile_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user_entity(id),
    FOREIGN KEY (profile_id) REFERENCES profile(id)
);