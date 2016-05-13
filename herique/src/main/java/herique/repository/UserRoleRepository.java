/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herique.repository;

import herique.entity.Role;
import herique.entity.Testes;
import herique.entity.User;
import herique.entity.UserRole;
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
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    @Query(value = "SELECT * FROM user_role ur WHERE id_user = ?1", nativeQuery = true)
    List<UserRole> findByUserId(Integer id);
//    @Query("SELECT t.title FROM Todo t where t.id = :id")
//    String findTitleById(@Param("id") Long id);
}
