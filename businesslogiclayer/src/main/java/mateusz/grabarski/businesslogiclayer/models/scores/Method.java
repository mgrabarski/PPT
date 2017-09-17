package mateusz.grabarski.businesslogiclayer.models.scores;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz Grabarski on 14.09.2017.
 */

public class Method {

    private List<Parameter> parameter;
    private String name;
    private String methodId;

    public Method() {
        parameter = new ArrayList<>();
    }

    public Method(List<Parameter> parameter, String name, String methodId) {
        this.parameter = parameter;
        this.name = name;
        this.methodId = methodId;
    }

    public List<Parameter> getParameter() {
        return parameter;
    }

    public void setParameter(List<Parameter> parameter) {
        this.parameter = parameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethodId() {
        return methodId;
    }

    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }

    public String getParameterByName(String name) {
        for (Parameter param : parameter)
            if (param.getName().equals(name))
                return param.getValue();

        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Method)) return false;

        Method method = (Method) o;

        if (getParameter() != null ? !getParameter().equals(method.getParameter()) : method.getParameter() != null)
            return false;
        if (getName() != null ? !getName().equals(method.getName()) : method.getName() != null)
            return false;
        return getMethodId() != null ? getMethodId().equals(method.getMethodId()) : method.getMethodId() == null;

    }

    @Override
    public int hashCode() {
        int result = getParameter() != null ? getParameter().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getMethodId() != null ? getMethodId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Method{" +
                "parameter=" + parameter +
                ", name='" + name + '\'' +
                ", methodId='" + methodId + '\'' +
                '}';
    }
}
