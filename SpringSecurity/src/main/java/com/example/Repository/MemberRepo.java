package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.MemberPo;

public interface MemberRepo extends JpaRepository<MemberPo, Long> {
	MemberPo findByUsername(String username);

}
