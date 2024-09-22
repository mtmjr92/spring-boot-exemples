CREATE TABLE public.grade_utm (
	id int4 NOT NULL,
	epsg int4 NOT NULL,
	geom public.geometry(multipolygon, 4326) NOT NULL,
	"name" varchar(100) NOT NULL,
	CONSTRAINT grade_utm_pkey PRIMARY KEY (id)
);