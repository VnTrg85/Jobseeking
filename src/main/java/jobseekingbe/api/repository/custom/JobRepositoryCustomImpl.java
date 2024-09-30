package jobseekingbe.api.repository.custom;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jobseekingbe.api.builder.JobSearchBuilder;
import jobseekingbe.api.entity.Job;
import jobseekingbe.api.model.JobDTO;

@Repository
public class JobRepositoryCustomImpl implements JobRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	public static void joinTable(JobSearchBuilder buider,StringBuilder sql) {
		String industry=buider.getIndustry();
		if(industry!=null) {
			sql.append("INNER JOIN company b ON a.company_id=b.id ");
		}
	}
	public static void queryNomal(JobSearchBuilder buider,StringBuilder where) {
		try {
			Field[] fields=buider.getClass().getDeclaredFields();
			for(Field item:fields) {
				item.setAccessible(true);
				String fieldName=item.getName();
				Object fieldValue=item.get(buider);
				if(fieldValue!=null) {
					if(!fieldName.startsWith("salary" )|| !fieldName.equals("industry")) {
						if(item.getType()==Long.class || item.getType()==Integer.class) {
							where.append(" AND a."+fieldName+" = "+"a."+fieldValue+" ");
						}else if(item.getType()==String.class) {
							where.append(" AND a."+fieldName+"LIKE '%"+fieldValue+"'% ");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void querySpecial(JobSearchBuilder builder,StringBuilder where ) {
		Long salaryFrom=Long.parseLong(builder.getSalaryFrom());
		Long salaryTo=Long.parseLong(builder.getSalaryTo());
		if(salaryFrom!=null ) {
			where.append(" AND a.salary>="+salaryFrom+" ");
		}
		if(salaryTo!=null ) {
			where.append(" AND a.salary<="+salaryTo+" ");
		}
		
		String industry=builder.getIndustry();
		if(industry!=null) {
			where.append(" AND b.industry LIKE '%"+industry+"%' " );
		}
		
		
	}
	
	
	
	@Override
	public List<Job> findJobs(JobSearchBuilder builder) {
		StringBuilder sql=new StringBuilder("select * from job a ");
		StringBuilder where=new StringBuilder("where 1=1 ");	
		joinTable(builder, sql);
		queryNomal(builder, where);
		querySpecial(builder, where);
		where.append(" GROUP BY a.id ");
		
		sql.append(where);
		Query query=entityManager.createNativeQuery(sql.toString(), Job.class);
		return query.getResultList();
	}

}
