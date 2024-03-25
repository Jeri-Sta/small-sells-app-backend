CREATE TABLE IF NOT EXISTS resource_profile_permission (
    id SERIAL PRIMARY KEY,
    profile_id BIGINT,
    resource_id BIGINT,
    FOREIGN KEY (profile_id) REFERENCES profile(id),
    FOREIGN KEY (resource_id) REFERENCES resource(id)
);