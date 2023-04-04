package template.springbootjpatemplate.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import static template.springbootjpatemplate.model.QSampleModel.sampleModel;


@Transactional
@Repository
public class SampleRepositoryCustomImpl implements SampleRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long findLastId() {
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        return jpaQueryFactory
                .select(sampleModel.id)
                .from(sampleModel)
                .orderBy(sampleModel.id.desc())
                .fetchFirst();
    }
}
