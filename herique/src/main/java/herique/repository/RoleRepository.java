/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herique.repository;

import herique.entity.Expression;
import herique.entity.Role;
import herique.entity.Testes;
import herique.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author hdias
 */
@Transactional
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

//    @Query(value = "SELECT * FROM expression WHERE id_role = :id", nativeQuery = true)
//    List<Expression> findExpressionByRoleId(@Param("id") Integer id);
    
//    @Query("SELECT t.title FROM Todo t where t.id = :id")
//    String findTitleById(@Param("id") Long id);

}
