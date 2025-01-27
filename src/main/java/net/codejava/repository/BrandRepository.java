package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.codejava.Model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
	Brand findOneById(int id);
}
