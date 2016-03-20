package com.dukescript.demoapp;
import net.java.html.json.*;
public final class Graph implements Cloneable {
  private static final Html4JavaType TYPE = new Html4JavaType();
  private final org.netbeans.html.json.spi.Proto proto;
  private java.lang.String prop_graphName;
  public java.lang.String getGraphName() {
    proto.accessProperty("graphName");
    return prop_graphName;
  }
  public void setGraphName(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_graphName;
    if (TYPE.isSame(o , v)) return;
    prop_graphName = v;
    proto.valueHasMutated("graphName", o, v);
  }
  private final java.util.List<StateTupel> prop_states;
  public java.util.List<StateTupel> getStates() {
    proto.accessProperty("states");
    return prop_states;
  }
  private static Class<DataModel.graphModel> modelFor() { return null; }
  private Graph(net.java.html.BrwsrCtx context) {
    this.proto = TYPE.createProto(this, context);
    this.prop_states = proto.createList("states", -1);
  };
  public Graph() {
    this(net.java.html.BrwsrCtx.findDefault(Graph.class));
  };
  public Graph(java.lang.String aGraphName, StateTupel... aStates) {
    this(net.java.html.BrwsrCtx.findDefault(Graph.class));
    this.prop_graphName = aGraphName;
    proto.initTo(this.prop_states, aStates);
  };
  private static class Html4JavaType extends org.netbeans.html.json.spi.Proto.Type<Graph> {
    private Html4JavaType() {
      super(Graph.class, DataModel.graphModel.class, 2, 0);
      registerProperty("graphName", 0, false);
      registerProperty("states", 1, false);
    }
    @Override public void setValue(Graph data, int type, Object value) {
      switch (type) {
        case 0: data.setGraphName(TYPE.extractValue(java.lang.String.class, value)); return;
        case 1: TYPE.replaceValue(data.getStates(), StateTupel.class, value); return;
      }
      throw new UnsupportedOperationException();
    }
    @Override public Object getValue(Graph data, int type) {
      switch (type) {
        case 0: return data.getGraphName();
        case 1: return data.getStates();
      }
      throw new UnsupportedOperationException();
    }
    @Override public void call(Graph model, int type, Object data, Object ev) throws Exception {
      switch (type) {
      }
      throw new UnsupportedOperationException();
    }
    @Override public org.netbeans.html.json.spi.Proto protoFor(Object obj) {
      return ((Graph)obj).proto;    }
    @Override public void onChange(Graph model, int type) {
      switch (type) {
    }
      throw new UnsupportedOperationException();
    }
  @Override public void onMessage(Graph model, int index, int type, Object data, Object[] params) {
    switch (index) {
    }
    throw new UnsupportedOperationException("index: " + index + " type: " + type);
  }
    @Override public Graph read(net.java.html.BrwsrCtx c, Object json) { return new Graph(c, json); }
    @Override public Graph cloneTo(Graph o, net.java.html.BrwsrCtx c) { return o.clone(c); }
  }
  private Graph(net.java.html.BrwsrCtx c, Object json) {
    this(c);
    Object[] ret = new Object[2];
    proto.extract(json, new String[] {
      "graphName",
      "states",
    }, ret);
    this.prop_graphName = (java.lang.String)ret[0];
    for (Object e : useAsArray(ret[1])) {
      this.prop_states.add(proto.read(StateTupel.class, e));
    }
  }
  private static Object[] useAsArray(Object o) {
    return o instanceof Object[] ? ((Object[])o) : o == null ? new Object[0] : new Object[] { o };
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('{');
    sb.append('"').append("graphName").append('"').append(":");
    sb.append(TYPE.toJSON(prop_graphName));
    sb.append(',');
    sb.append('"').append("states").append('"').append(":");
    sb.append(TYPE.toJSON(prop_states));
    sb.append('}');
    return sb.toString();
  }
  public Graph clone() {
    return clone(proto.getContext());
  }
  private Graph clone(net.java.html.BrwsrCtx ctx) {
    Graph ret = new Graph(ctx);
    ret.prop_graphName = getGraphName();
    proto.cloneList(ret.getStates(), ctx, prop_states);
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
  public Graph applyBindings() {
    proto.applyBindings();
    return this;
  }
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Graph)) return false;
    Graph p = (Graph)o;
    if (!TYPE.isSame(prop_graphName, p.prop_graphName)) return false;
    if (!TYPE.isSame(prop_states, p.prop_states)) return false;
    return true;
  }
  public int hashCode() {
    int h = Graph.class.getName().hashCode();
    h = TYPE.hashPlus(prop_graphName, h);
    h = TYPE.hashPlus(prop_states, h);
    return h;
  }
}
