package fourth.entities.classes;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Class {
    private List<Learner> learners;
    private Map<WeekDay, DailySchedule> dailySchedules;

    public Class() {
        learners = new ArrayList<>();
        dailySchedules = new EnumMap<>(WeekDay.class);
    }

    public Class(List<Learner> learners, Map<WeekDay, DailySchedule> dailySchedules) {
        this.learners = learners;
        this.dailySchedules = dailySchedules;
    }

    public List<Learner> getLearners() {
        return learners;
    }

    public void setLearners(List<Learner> learners) {
        this.learners = learners;
    }

    public Map<WeekDay, DailySchedule> getDailySchedules() {
        return dailySchedules;
    }

    public void setDailySchedules(Map<WeekDay, DailySchedule> dailySchedules) {
        this.dailySchedules = dailySchedules;
    }

    public void addLearner(Learner learner) {
        learners.add(learner);
    }

    public Learner getLearnerByIndex(int index) {
        return learners.get(index);
    }

    public Learner removeLearnerByIndex(int index) {
        return learners.remove(index);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE)
                .append("learners", learners)
                .append("dailySchedules", dailySchedules)
                .toString();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Class rhs = (Class) obj;
        return new EqualsBuilder()
                .append(this.learners, rhs.learners)
                .append(this.dailySchedules, rhs.dailySchedules)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(learners)
                .append(dailySchedules)
                .toHashCode();
    }
}
