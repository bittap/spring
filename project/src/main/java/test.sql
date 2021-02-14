select * from EMPLOYEES where employee_id = '100' and employee_id = '100'

select * from member_Table where 1=1 and member_signDate >= '2016-04-12'

select b.* from (select rownum as rowm,a.* from (select * from member_Table where 1=1)a)b
where b.rowm<=10 and member_signDate >= '2016-04-12'

		select b.* from (select rownum as rowm,a.* from (select * from board order by ref desc,re_step)a)b
		where b.rowm>=#{startRow} and b.rowm<=#{endRow}
		
		select b.* from (select rownum as rowm,a.* from (select * from
		member_Table where 1=1)a)b
		where b.rowm<=10
		
		select * from member_Table where 1=1 order by member_signDate desc
		
		<![CDATA[select b.* from (select rownum as rowm,a.* from (select * from
		member_Table where 1=1)a)b
		]]>
		
		 and member_signDate >= '2016-04-12'
		 
		 select b.* from (select rownum as rowm,a.* from (select * from
		member_Table where 1=1)a)b
		where b.rowm>=1 and b.rowm<=5 order by member_purchaseAmount desc
		
		select count(*) from member_Table m, orderTable o where m.member_id = o.member_id