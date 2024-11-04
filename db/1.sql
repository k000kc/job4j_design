select p.name as "Имя сотрудника", c.name as "Имя компании" 
	from person p join company c on c.id = p.company_id
where c.id != 5;