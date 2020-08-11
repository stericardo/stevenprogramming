package com.example.demo.specification;

import com.example.demo.entity.Employee;
import com.example.demo.filter.EmployeeFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EmployeeSpecification implements Specification<Employee> {

    private EmployeeFilter filter;
    private Predicate predicate;

    public EmployeeSpecification(EmployeeFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (filter.getWords().length > 0) {
            if( filter.getType() == 1){
                processType1(root, criteriaBuilder);
            } else if( filter.getType() == 2){
                processType2(root, criteriaBuilder);
            }
        }
        
        return predicate;
    }

    private void processType1(Root<Employee> root, CriteriaBuilder criteriaBuilder){
        for(String description : filter.getWords()){
            Predicate newPredicate =
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("description")),
                            getLikePattern(description.toLowerCase()));
            predicate = this.getPredicate(newPredicate, Predicate.BooleanOperator.AND,
                    criteriaBuilder);
        }
    }

    private void processType2(Root<Employee> root, CriteriaBuilder cb){
        for(String description : filter.getWords()){
            Predicate newPredicate = cb.like(cb.lower(root.get("description")),
                            getLikePattern(description.toLowerCase()));
            predicate = this.getPredicate(newPredicate, Predicate.BooleanOperator.AND,cb);
        }
    }
    private void processType3(Root<Employee> root, CriteriaBuilder cb){
        for(String description : filter.getWords()){
            Predicate newPredicate = cb.like(cb.lower(root.get("description")),
                    getLikePattern(description.toLowerCase()));
            predicate = this.getPredicate(newPredicate, Predicate.BooleanOperator.OR, cb);
        }
    }

/*
        accountNamePredicate = BooleanUtils.isTrue(filter.getExcludeAccountNameAndCategory())
                ? cb.like(cb.lower(root.join("account").get("name")), nameLikePattern).not()
                : cb.like(cb.lower(root.join("account").get("name")), nameLikePattern);
    }
        if (CollectionUtils.isNotEmpty(filter.getAccountCategories())) {
        accountCategoryPredicate = BooleanUtils.isTrue(filter.getExcludeAccountNameAndCategory())
                ? root.join("account").get("fullyQualifiedCategory").in(filter.getAccountCategories()).not()
                : root.join("account").get("fullyQualifiedCategory").in(filter.getAccountCategories());
    }
    */



    private Predicate getPredicate(Predicate newPredicate, Predicate.BooleanOperator operator,
                                   CriteriaBuilder criteriaBuilder) {
        if (predicate == null) {
            return newPredicate;
        }
        predicate = operator == Predicate.BooleanOperator.AND ?
                criteriaBuilder.and(predicate, newPredicate)
                : criteriaBuilder.or(predicate, newPredicate);
        return predicate;
    }

    public String getLikePattern(final String searchTerm) {
        StringBuilder pattern = new StringBuilder();
        pattern.append("%");
        pattern.append(searchTerm);
        pattern.append("%");
        return pattern.toString();
    }
}
