create or replace procedure p_delete_if_count_equals_zero()
language 'plpgsql' as $$
begin
	delete from products where count = 0;
end;
$$;

call p_delete_if_count_equals_zero();

create or replace function f_delete_by_id(product_id int)
returns integer
language 'plpgsql' as $$
declare
	result integer;
begin
	delete from products where id = product_id
	returning id into result;
	return result; 
end;
$$;

select f_delete_by_id(4);