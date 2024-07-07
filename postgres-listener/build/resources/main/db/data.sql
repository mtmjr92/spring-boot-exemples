CREATE OR REPLACE FUNCTION notify_random_number_change() RETURNS TRIGGER AS $$
DECLARE
    payload JSON;
BEGIN
    payload = json_build_object(
        'table', TG_TABLE_NAME,
        'data', row_to_json(NEW)
    );
    PERFORM pg_notify('random_number_change', payload::text);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER random_number_change_trigger
AFTER UPDATE OF random_number ON user_data
FOR EACH ROW
EXECUTE FUNCTION notify_random_number_change();;