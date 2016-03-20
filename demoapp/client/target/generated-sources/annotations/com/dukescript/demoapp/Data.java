package com.dukescript.demoapp;
import net.java.html.json.*;
public final class Data implements Cloneable {
  private static final Html4JavaType TYPE = new Html4JavaType();
  private final org.netbeans.html.json.spi.Proto proto;
  public java.util.List<java.lang.String> getOptions() {
    java.util.List<Graph> arg1 = getSavedGraphs();
    try {
      proto.acquireLock("options");
      return com.dukescript.demoapp.DataModel.options(arg1);
    } finally {
      proto.releaseLock();
    }
  }
  private java.lang.String prop_saveName;
  public java.lang.String getSaveName() {
    proto.accessProperty("saveName");
    return prop_saveName;
  }
  public void setSaveName(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_saveName;
    if (TYPE.isSame(o , v)) return;
    prop_saveName = v;
    proto.valueHasMutated("saveName", o, v);
  }
  private java.lang.String prop_selectedGraph;
  public java.lang.String getSelectedGraph() {
    proto.accessProperty("selectedGraph");
    return prop_selectedGraph;
  }
  public void setSelectedGraph(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_selectedGraph;
    if (TYPE.isSame(o , v)) return;
    prop_selectedGraph = v;
    proto.valueHasMutated("selectedGraph", o, v);
  }
  private Graph prop_graph;
  public Graph getGraph() {
    proto.accessProperty("graph");
    return prop_graph;
  }
  public void setGraph(Graph v) {
    proto.verifyUnlocked();
    Object o = prop_graph;
    if (o == v) return;
    prop_graph = v;
    proto.valueHasMutated("graph", o, v);
  }
  private final java.util.List<Graph> prop_savedGraphs;
  public java.util.List<Graph> getSavedGraphs() {
    proto.accessProperty("savedGraphs");
    return prop_savedGraphs;
  }
  private int prop_xCoord;
  public int getXCoord() {
    proto.accessProperty("xCoord");
    return prop_xCoord;
  }
  public void setXCoord(int v) {
    proto.verifyUnlocked();
    Object o = prop_xCoord;
    if (TYPE.isSame(o , v)) return;
    prop_xCoord = v;
    proto.valueHasMutated("xCoord", o, v);
  }
  private int prop_yCoord;
  public int getYCoord() {
    proto.accessProperty("yCoord");
    return prop_yCoord;
  }
  public void setYCoord(int v) {
    proto.verifyUnlocked();
    Object o = prop_yCoord;
    if (TYPE.isSame(o , v)) return;
    prop_yCoord = v;
    proto.valueHasMutated("yCoord", o, v);
  }
  private java.lang.String prop_mode;
  public java.lang.String getMode() {
    proto.accessProperty("mode");
    return prop_mode;
  }
  public void setMode(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_mode;
    if (TYPE.isSame(o , v)) return;
    prop_mode = v;
    proto.valueHasMutated("mode", o, v);
  }
  private java.lang.String prop_displayString;
  public java.lang.String getDisplayString() {
    proto.accessProperty("displayString");
    return prop_displayString;
  }
  public void setDisplayString(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_displayString;
    if (TYPE.isSame(o , v)) return;
    prop_displayString = v;
    proto.valueHasMutated("displayString", o, v);
  }
  private static Class<DataModel> modelFor() { return null; }
  private Data(net.java.html.BrwsrCtx context) {
    this.proto = TYPE.createProto(this, context);
    this.prop_savedGraphs = proto.createList("savedGraphs", -1, "options");
  };
  public Data() {
    this(net.java.html.BrwsrCtx.findDefault(Data.class));
    prop_graph = new Graph();
  };
  public Data(java.lang.String aSaveName, java.lang.String aSelectedGraph, Graph aGraph, int aXCoord, int aYCoord, java.lang.String aMode, java.lang.String aDisplayString, Graph... aSavedGraphs) {
    this(net.java.html.BrwsrCtx.findDefault(Data.class));
    this.prop_saveName = aSaveName;
    this.prop_selectedGraph = aSelectedGraph;
    this.prop_graph = aGraph;
    this.prop_xCoord = aXCoord;
    this.prop_yCoord = aYCoord;
    this.prop_mode = aMode;
    this.prop_displayString = aDisplayString;
    proto.initTo(this.prop_savedGraphs, aSavedGraphs);
  };
  private static class Html4JavaType extends org.netbeans.html.json.spi.Proto.Type<Data> {
    private Html4JavaType() {
      super(Data.class, DataModel.class, 9, 14);
      registerProperty("options", 0, true);
      registerProperty("saveName", 1, false);
      registerProperty("selectedGraph", 2, false);
      registerProperty("graph", 3, false);
      registerProperty("savedGraphs", 4, false);
      registerProperty("xCoord", 5, false);
      registerProperty("yCoord", 6, false);
      registerProperty("mode", 7, false);
      registerProperty("displayString", 8, false);
      registerFunction("mousePressed", 0);
      registerFunction("saveGraph", 1);
      registerFunction("loadGraph", 2);
      registerFunction("clearCanvas", 3);
      registerFunction("handleMouseDown", 4);
      registerFunction("handleMouseUp", 5);
      registerFunction("updateMaus", 6);
      registerFunction("refreshCanvas", 7);
      registerFunction("initCanvas", 8);
      registerFunction("resizeCanvas", 9);
      registerFunction("dragMode", 10);
      registerFunction("drawTransitionMode", 11);
      registerFunction("addState", 12);
      registerFunction("decreaseStates", 13);
    }
    @Override public void setValue(Data data, int type, Object value) {
      switch (type) {
        case 1: data.setSaveName(TYPE.extractValue(java.lang.String.class, value)); return;
        case 2: data.setSelectedGraph(TYPE.extractValue(java.lang.String.class, value)); return;
        case 3: data.setGraph(TYPE.extractValue(Graph.class, value)); return;
        case 4: TYPE.replaceValue(data.getSavedGraphs(), Graph.class, value); return;
        case 5: data.setXCoord(TYPE.extractValue(java.lang.Integer.class, value)); return;
        case 6: data.setYCoord(TYPE.extractValue(java.lang.Integer.class, value)); return;
        case 7: data.setMode(TYPE.extractValue(java.lang.String.class, value)); return;
        case 8: data.setDisplayString(TYPE.extractValue(java.lang.String.class, value)); return;
      }
      throw new UnsupportedOperationException();
    }
    @Override public Object getValue(Data data, int type) {
      switch (type) {
        case 0: return data.getOptions();
        case 1: return data.getSaveName();
        case 2: return data.getSelectedGraph();
        case 3: return data.getGraph();
        case 4: return data.getSavedGraphs();
        case 5: return data.getXCoord();
        case 6: return data.getYCoord();
        case 7: return data.getMode();
        case 8: return data.getDisplayString();
      }
      throw new UnsupportedOperationException();
    }
    @Override public void call(Data model, int type, Object data, Object ev) throws Exception {
      switch (type) {
        case 0:
          com.dukescript.demoapp.DataModel.mousePressed(model, model.proto.toNumber(ev, "realX").intValue(), model.proto.toNumber(ev, "realY").intValue());
          return;
        case 1:
          com.dukescript.demoapp.DataModel.saveGraph();
          return;
        case 2:
          com.dukescript.demoapp.DataModel.loadGraph();
          return;
        case 3:
          com.dukescript.demoapp.DataModel.clearCanvas();
          return;
        case 4:
          com.dukescript.demoapp.DataModel.handleMouseDown();
          return;
        case 5:
          com.dukescript.demoapp.DataModel.handleMouseUp();
          return;
        case 6:
          com.dukescript.demoapp.DataModel.updateMaus(model.proto.toNumber(ev, "realX").intValue(), model.proto.toNumber(ev, "realY").intValue());
          return;
        case 7:
          com.dukescript.demoapp.DataModel.refreshCanvas();
          return;
        case 8:
          com.dukescript.demoapp.DataModel.initCanvas();
          return;
        case 9:
          com.dukescript.demoapp.DataModel.resizeCanvas();
          return;
        case 10:
          com.dukescript.demoapp.DataModel.dragMode();
          return;
        case 11:
          com.dukescript.demoapp.DataModel.drawTransitionMode();
          return;
        case 12:
          com.dukescript.demoapp.DataModel.addState();
          return;
        case 13:
          com.dukescript.demoapp.DataModel.decreaseStates();
          return;
      }
      throw new UnsupportedOperationException();
    }
    @Override public org.netbeans.html.json.spi.Proto protoFor(Object obj) {
      return ((Data)obj).proto;    }
    @Override public void onChange(Data model, int type) {
      switch (type) {
    }
      throw new UnsupportedOperationException();
    }
  @Override public void onMessage(Data model, int index, int type, Object data, Object[] params) {
    switch (index) {
    }
    throw new UnsupportedOperationException("index: " + index + " type: " + type);
  }
    @Override public Data read(net.java.html.BrwsrCtx c, Object json) { return new Data(c, json); }
    @Override public Data cloneTo(Data o, net.java.html.BrwsrCtx c) { return o.clone(c); }
  }
  private Data(net.java.html.BrwsrCtx c, Object json) {
    this(c);
    Object[] ret = new Object[8];
    proto.extract(json, new String[] {
      "saveName",
      "selectedGraph",
      "graph",
      "savedGraphs",
      "xCoord",
      "yCoord",
      "mode",
      "displayString",
    }, ret);
    this.prop_saveName = (java.lang.String)ret[0];
    this.prop_selectedGraph = (java.lang.String)ret[1];
    this.prop_graph = proto.read(Graph.class, ret[2]);
    for (Object e : useAsArray(ret[3])) {
      this.prop_savedGraphs.add(proto.read(Graph.class, e));
    }
    this.prop_xCoord = ret[4] == null ? 0 : (TYPE.numberValue(ret[4])).intValue();
    this.prop_yCoord = ret[5] == null ? 0 : (TYPE.numberValue(ret[5])).intValue();
    this.prop_mode = (java.lang.String)ret[6];
    this.prop_displayString = (java.lang.String)ret[7];
  }
  private static Object[] useAsArray(Object o) {
    return o instanceof Object[] ? ((Object[])o) : o == null ? new Object[0] : new Object[] { o };
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('{');
    sb.append('"').append("saveName").append('"').append(":");
    sb.append(TYPE.toJSON(prop_saveName));
    sb.append(',');
    sb.append('"').append("selectedGraph").append('"').append(":");
    sb.append(TYPE.toJSON(prop_selectedGraph));
    sb.append(',');
    sb.append('"').append("graph").append('"').append(":");
    sb.append(TYPE.toJSON(prop_graph));
    sb.append(',');
    sb.append('"').append("savedGraphs").append('"').append(":");
    sb.append(TYPE.toJSON(prop_savedGraphs));
    sb.append(',');
    sb.append('"').append("xCoord").append('"').append(":");
    sb.append(TYPE.toJSON(prop_xCoord));
    sb.append(',');
    sb.append('"').append("yCoord").append('"').append(":");
    sb.append(TYPE.toJSON(prop_yCoord));
    sb.append(',');
    sb.append('"').append("mode").append('"').append(":");
    sb.append(TYPE.toJSON(prop_mode));
    sb.append(',');
    sb.append('"').append("displayString").append('"').append(":");
    sb.append(TYPE.toJSON(prop_displayString));
    sb.append('}');
    return sb.toString();
  }
  public Data clone() {
    return clone(proto.getContext());
  }
  private Data clone(net.java.html.BrwsrCtx ctx) {
    Data ret = new Data(ctx);
    ret.prop_saveName = getSaveName();
    ret.prop_selectedGraph = getSelectedGraph();
    ret.prop_graph =  getGraph()  == null ? null : prop_graph.clone();
    proto.cloneList(ret.getSavedGraphs(), ctx, prop_savedGraphs);
    ret.prop_xCoord = getXCoord();
    ret.prop_yCoord = getYCoord();
    ret.prop_mode = getMode();
    ret.prop_displayString = getDisplayString();
    return ret;
  }
  /** Activates this model instance in the current {@link 
net.java.html.json.Models#bind(java.lang.Object, net.java.html.BrwsrCtx) browser context}. 
In case of using Knockout technology, this means to 
bind JSON like data in this model instance with Knockout tags in 
the surrounding HTML page.
This method binds to element '""' on the page
@return <code>this</code> object
*/
  public Data applyBindings() {
    proto.applyBindings();
    return this;
  }
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Data)) return false;
    Data p = (Data)o;
    if (!TYPE.isSame(prop_saveName, p.prop_saveName)) return false;
    if (!TYPE.isSame(prop_selectedGraph, p.prop_selectedGraph)) return false;
    if (!TYPE.isSame(prop_graph, p.prop_graph)) return false;
    if (!TYPE.isSame(prop_savedGraphs, p.prop_savedGraphs)) return false;
    if (!TYPE.isSame(prop_xCoord, p.prop_xCoord)) return false;
    if (!TYPE.isSame(prop_yCoord, p.prop_yCoord)) return false;
    if (!TYPE.isSame(prop_mode, p.prop_mode)) return false;
    if (!TYPE.isSame(prop_displayString, p.prop_displayString)) return false;
    return true;
  }
  public int hashCode() {
    int h = Data.class.getName().hashCode();
    h = TYPE.hashPlus(prop_saveName, h);
    h = TYPE.hashPlus(prop_selectedGraph, h);
    h = TYPE.hashPlus(prop_graph, h);
    h = TYPE.hashPlus(prop_savedGraphs, h);
    h = TYPE.hashPlus(prop_xCoord, h);
    h = TYPE.hashPlus(prop_yCoord, h);
    h = TYPE.hashPlus(prop_mode, h);
    h = TYPE.hashPlus(prop_displayString, h);
    return h;
  }
}
