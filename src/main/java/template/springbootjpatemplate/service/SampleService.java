package template.springbootjpatemplate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import template.springbootjpatemplate.model.SampleModel;
import template.springbootjpatemplate.repository.SampleRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SampleService {

    private final SampleRepository sampleRepository;

    public List<SampleModel> getAllSampleModels() {
        return sampleRepository.findAll();
    }

    public SampleModel getSampleModelById(Long id) {
        return sampleRepository.findById(id).orElse(null);
    }

    public Long saveSampleModel(SampleModel sampleModel) {
        Long newId = sampleRepository.findLastId() + 1;
        return sampleRepository.save(new SampleModel(newId, sampleModel.getName(), sampleModel.getEmail())).getId();
    }

    public void deleteSampleModel(Long id) {
        sampleRepository.deleteById(id);
    }
}