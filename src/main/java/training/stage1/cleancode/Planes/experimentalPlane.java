package training.stage1.cleancode.Planes;

import training.stage1.cleancode.models.ClassificationLevel;
import training.stage1.cleancode.models.ExperimentalTypes;

import java.util.Objects;

public class experimentalPlane extends Plane {

    private ExperimentalTypes experimentalType;
    private ClassificationLevel classificationLevel;

    public experimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes experimentalType, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = experimentalType;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof experimentalPlane)) return false;
        if (!super.equals(object)) return false;
        experimentalPlane that = (experimentalPlane) object;
        return model == that.model;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), model);
    }

    @Override
    public String toString() {
        return "experimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }
}
