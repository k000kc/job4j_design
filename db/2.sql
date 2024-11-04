select c.name as "Имя компании", count(p.id)as "Число сотрудников" from company c join person p on c.id = p.company_id 
group by c.name 
having count(p.id) = (select max(person_count) from (select count(p.id) person_count from person p group by p.company_id));