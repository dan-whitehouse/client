package org.ricone.api.client.response.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"xLea"})
@JsonRootName(value = "xLeas")
public class XLeas {
    @JsonProperty("xLea")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<XLea> xLea;

    public XLeas() {
        xLea = new ArrayList<>();
    }

    public XLeas(List<XLea> xLea) {
        super();
        this.xLea = xLea;
    }

    @JsonProperty("xLea")
    public List<XLea> getXLea() {
        return xLea;
    }

    @JsonProperty("xLea")
    public void setXLea(List<XLea> xLea) {
        this.xLea = xLea;
    }

    @Override
    public String toString() {
        return "XLeas{" + "xLea=" + xLea + '}';
    }
}