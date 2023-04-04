package template.springbootjpatemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import template.springbootjpatemplate.model.SampleModel;

@Repository
public interface SampleRepository extends JpaRepository<SampleModel, Long>, SampleRepositoryCustom{

}