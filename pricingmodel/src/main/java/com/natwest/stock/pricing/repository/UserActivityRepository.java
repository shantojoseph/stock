package com.natwest.stock.pricing.repository;

import com.natwest.stock.user.enitty.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {

    @Query("select count(distinct stock_symbol) from UserActivity where  user_id= :userId and activity_date between :fromDate and :toDate ")
    Long findStocksByUserIdAndPeriod(Long userId, LocalDateTime fromDate, LocalDateTime toDate);

    @Query("select count( 1) from UserActivity where  user_id= :userId and activity_date between :fromDate and :toDate ")
    Long findCallsByUserIdAndPeriod(Long userId, LocalDateTime fromDate, LocalDateTime toDate);

}
