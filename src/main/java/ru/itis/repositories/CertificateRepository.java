package ru.itis.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.models.Certificate;

public interface CertificateRepository extends CrudRepository<Certificate, Long> {
}
