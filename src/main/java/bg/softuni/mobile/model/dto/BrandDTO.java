package bg.softuni.mobile.model.dto;

import java.util.ArrayList;
import java.util.List;

public class BrandDTO {

    private String name;

    private List<ModelDTO> models = new ArrayList<>();

    public String getName() {
        return name;
    }

    public BrandDTO setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelDTO> getModels() {
        return models;
    }

    public BrandDTO setModels(List<ModelDTO> models) {
        this.models = models;
        return this;
    }

    public BrandDTO addModels(ModelDTO model) {

        if (this.models == null) {
            this.models = new ArrayList<>();
        }

        this.models.add(model);
        return this;
    }
}
