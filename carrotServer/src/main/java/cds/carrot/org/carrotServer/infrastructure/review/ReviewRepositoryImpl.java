package cds.carrot.org.carrotServer.infrastructure.review;


import org.springframework.data.repository.Repository;

public interface ReviewRepositoryImpl extends Repository<ReviewEntity, Long>, ReviewRepository {

}
