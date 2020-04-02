DO $$ BEGIN ALTER TABLE actual_opening_hours ALTER COLUMN creation_date TYPE TIMESTAMP WITHOUT TIME ZONE; EXCEPTION WHEN OTHERS THEN END; $$;
DO $$ BEGIN ALTER TABLE exceptional_hours ALTER COLUMN creation_date TYPE TIMESTAMP WITHOUT TIME ZONE; EXCEPTION WHEN OTHERS THEN END; $$;
DO $$ BEGIN ALTER TABLE openings ALTER COLUMN creation_date TYPE TIMESTAMP WITHOUT TIME ZONE; EXCEPTION WHEN OTHERS THEN END; $$;
DO $$ BEGIN ALTER TABLE regular_hours ALTER COLUMN creation_date TYPE TIMESTAMP WITHOUT TIME ZONE; EXCEPTION WHEN OTHERS THEN END; $$;
DO $$ BEGIN ALTER TABLE exceptions ALTER COLUMN creation_date TYPE TIMESTAMP WITHOUT TIME ZONE; EXCEPTION WHEN OTHERS THEN END; $$;
