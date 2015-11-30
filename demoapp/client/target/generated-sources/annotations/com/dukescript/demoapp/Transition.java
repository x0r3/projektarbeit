package com.dukescript.demoapp;
import net.java.html.json.*;
public final class Transition implements Cloneable {
  private static final Html4JavaType TYPE = new Html4JavaType();
  private final org.netbeans.html.json.spi.Proto proto;
  private java.lang.String prop_value;
  public java.lang.String getValue() {
    proto.accessProperty("value");
    return prop_value;
  }
  public void setValue(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_value;
    if (TYPE.isSame(o , v)) return;
    prop_value = v;
    proto.valueHasMutated("value", o, v);
  }
  private java.lang.String prop_to;
  public java.lang.String getTo() {
    proto.accessProperty("to");
    return prop_to;
  }
  public void setTo(java.lang.String v) {
    proto.verifyUnlocked();
    Object o = prop_to;
    if (TYPE.isSame(o , v)) return;
    prop_to = v;
    proto.valueHasMutated("to", o, v);
  }
  private final java.util.List<java.lang.Integer> prop_coordsFrom;
  public java.util.List<java.lang.Integer> getCoordsFrom() {
    proto.accessProperty("coordsFrom");
    return prop_coordsFrom;
  }
  private final java.util.List<java.lang.Integer> prop_coordsTo;
  public java.util.List<java.lang.Integer> getCoordsTo() {
    proto.accessProperty("coordsTo");
    return prop_coordsTo;
  }
  private static Class<DataModel.TransitionModel> modelFor() { return null; }
  private Transition(net.java.html.BrwsrCtx context) {
    this.proto = TYPE.createProto(this, context);
    this.prop_coordsFrom = proto.createList("coordsFrom", -1);
    this.prop_coordsTo = proto.createList("coordsTo", -1);
  };
  public Transition() {
    this(net.java.html.BrwsrCtx.findDefault(Transition.class));
  };
  public Transition(java.lang.String aValue, java.lang.String aTo, int... aCoordsFrom) {
    this(net.java.html.BrwsrCtx.findDefault(Transition.class));
    this.prop_value = aValue;
    this.prop_to = aTo;
    proto.initTo(this.prop_coordsFrom, aCoordsFrom);
  };
  private static class Html4JavaType extends org.netbeans.html.json.spi.Proto.Type<Transition> {
    private Html4JavaType() {
      super(Transition.class, DataModel.TransitionModel.class, 4, 0);
      registerProperty("value", 0, false);
      registerProperty("to", 1, false);
      registerProperty("coordsFrom", 2, false);
      registerProperty("coordsTo", 3, false);
    }
    @Override public void setValue(Transition data, int type, Object value) {
      switch (type) {
        case 0: data.setValue(TYPE.extractValue(java.lang.String.class, value)); return;
        case 1: data.setTo(TYPE.extractValue(java.lang.String.class, value)); return;
        case 2: TYPE.replaceValue(data.getCoordsFrom(), java.lang.Integer.class, value); return;
        case 3: TYPE.replaceValue(data.getCoordsTo(), java.lang.Integer.class, value); return;
      }
      throw new UnsupportedOperationException();
    }
    @Override public Object getValue(Transition data, int type) {
      switch (type) {
        case 0: return data.getValue();
        case 1: return data.getTo();
        case 2: return data.getCoordsFrom();
        case 3: return data.getCoordsTo();
      }
      throw new UnsupportedOperationException();
    }
    @Override public void call(Transition model, int type, Object data, Object ev) throws Exception {
      switch (type) {
      }
      throw new UnsupportedOperationException();
    }
    @Override public org.netbeans.html.json.spi.Proto protoFor(Object obj) {
      return ((Transition)obj).proto;    }
    @Override public void onChange(Transition model, int type) {
      switch (type) {
    }
      throw new UnsupportedOperationException();
    }
  @Override public void onMessage(Transition model, int index, int type, Object data, Object[] params) {
    switch (index) {
    }
    throw new UnsupportedOperationException("index: " + index + " type: " + type);
  }
    @Override public Transition read(net.java.html.BrwsrCtx c, Object json) { return new Transition(c, json); }
    @Override public Transition cloneTo(Transition o, net.java.html.BrwsrCtx c) { return o.clone(c); }
  }
  private Transition(net.java.html.BrwsrCtx c, Object json) {
    this(c);
    Object[] ret = new Object[4];
    proto.extract(json, new String[] {
      "value",
      "to",
      "coordsFrom",
      "coordsTo",
    }, ret);
    this.prop_value = (java.lang.String)ret[0];
    this.prop_to = (java.lang.String)ret[1];
    for (Object e : useAsArray(ret[2])) {
        this.prop_coordsFrom.add(TYPE.numberValue(e).intValue());
    }
    for (Object e : useAsArray(ret[3])) {
        this.prop_coordsTo.add(TYPE.numberValue(e).intValue());
    }
  }
  private static Object[] useAsArray(Object o) {
    return o instanceof Object[] ? ((Object[])o) : o == null ? new Object[0] : new Object[] { o };
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('{');
    sb.append('"').append("value").append('"').append(":");
    sb.append(TYPE.toJSON(prop_value));
    sb.append(',');
    sb.append('"').append("to").append('"').append(":");
    sb.append(TYPE.toJSON(prop_to));
    sb.append(',');
    sb.append('"').append("coordsFrom").append('"').append(":");
    sb.append(TYPE.toJSON(prop_coordsFrom));
    sb.append(',');
    sb.append('"').append("coordsTo").append('"').append(":");
    sb.append(TYPE.toJSON(prop_coordsTo));
    sb.append('}');
    return sb.toString();
  }
  public Transition clone() {
    return clone(proto.getContext());
  }
  private Transition clone(net.java.html.BrwsrCtx ctx) {
    Transition ret = new Transition(ctx);
    ret.prop_value = getValue();
    ret.prop_to = getTo();
    proto.cloneList(ret.getCoordsFrom(), ctx, prop_coordsFrom);
    proto.cloneList(ret.getCoordsTo(), ctx, prop_coordsTo);
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
  public Transition applyBindings() {
    proto.applyBindings();
    return this;
  }
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Transition)) return false;
    Transition p = (Transition)o;
    if (!TYPE.isSame(prop_value, p.prop_value)) return false;
    if (!TYPE.isSame(prop_to, p.prop_to)) return false;
    if (!TYPE.isSame(prop_coordsFrom, p.prop_coordsFrom)) return false;
    if (!TYPE.isSame(prop_coordsTo, p.prop_coordsTo)) return false;
    return true;
  }
  public int hashCode() {
    int h = Transition.class.getName().hashCode();
    h = TYPE.hashPlus(prop_value, h);
    h = TYPE.hashPlus(prop_to, h);
    h = TYPE.hashPlus(prop_coordsFrom, h);
    h = TYPE.hashPlus(prop_coordsTo, h);
    return h;
  }
}
