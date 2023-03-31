package template.springbootjpatemplate.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import template.springbootjpatemplate.model.SampleModel;
import template.springbootjpatemplate.service.SampleService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequestMapping("/api/v1/samples")
@RequiredArgsConstructor
@RestController
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/")
    public ResponseEntity<List<SampleModel>> getAllSampleModels() {
        List<SampleModel> sampleModels = sampleService.getAllSampleModels();
        return Optional.of(sampleModels)
                .filter(sampleModel -> !sampleModel.isEmpty())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping("/")
    public ResponseEntity<Long> saveSampleModel(@RequestBody SampleModel sampleModel) {
        Long sampleModelId = sampleService.saveSampleModel(sampleModel);
        return new ResponseEntity<>(sampleModelId, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SampleModel> getSampleModelById(@PathVariable Long id) {
        SampleModel sampleModel = sampleService.getSampleModelById(id);
        return Optional.ofNullable(sampleModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSampleModel(@PathVariable Long id) {
        sampleService.deleteSampleModel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}