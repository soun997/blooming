package com.fivengers.blooming.project.adapter.out.persistence.repository;


import com.fivengers.blooming.project.adapter.out.persistence.entity.ProjectImageJpaEntity;
import com.fivengers.blooming.project.adapter.out.persistence.entity.ProjectJpaEntity;
import com.fivengers.blooming.project.adapter.out.persistence.mapper.ProjectImageMapper;
import com.fivengers.blooming.project.adapter.out.persistence.mapper.ProjectMapper;
import com.fivengers.blooming.project.application.port.out.ProjectImagePort;
import com.fivengers.blooming.project.domain.Project;
import com.fivengers.blooming.project.domain.ProjectImage;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProjectImagePersistenceAdapter implements ProjectImagePort {

    private final ProjectImageMapper projectImageMapper;
    private final ProjectImageSpringDataRepository projectImageSpringDataRepository;

    @Override
    public List<ProjectImage> findAllByProjectId(Long id) {
        List<ProjectImageJpaEntity> projectImages =
                projectImageSpringDataRepository.findAllByProjectId(id);
        return projectImages.stream()
                .map(projectImageMapper::toDomain)
                .toList();
    }
}