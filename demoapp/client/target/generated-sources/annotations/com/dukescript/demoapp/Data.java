package com.dukescript.demoapp;
import net.java.html.json.*;
public final class Data implements Cloneable {
  private static final Html4JavaType TYPE = new Html4JavaType();
  private final org.netbeans.html.json.spi.Proto proto;
  private final java.util.List<StateTupel> prop_states;
  public java.util.List<StateTupel> getStates() {
    proto.accessProperty("states");
    return prop_states;
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
    this.prop_states = proto.createList("states", -1);
  };
  public Data() {
    this(net.java.html.BrwsrCtx.findDefault(Data.class));
  };
  public Data(int aXCoord, int aYCoord, java.lang.String aMode, java.lang.String aDisplayString, StateTupel... aStates) {
    this(net.java.html.BrwsrCtx.findDefault(Data.class));
    this.prop_xCoord = aXCoord;
    this.prop_yCoord = aYCoord;
    this.prop_mode = aMode;
    this.prop_displayString = aDisplayString;
    proto.initTo(this.prop_states, aStates);
  };
  private static class Html4JavaType extends org.netbeans.html.json.spi.Proto.Type<Data> {
    private Html4JavaType() {
      super(Data.class, DataModel.class, 5, 12);
      registerProperty("states", 0, false);
      registerProperty("xCoord", 1, false);
      registerProperty("yCoord", 2, false);
      registerProperty("mode", 3, false);
      registerProperty("displayString", 4, false);
      registerFunction("mousePressed", 0);
      registerFunction("clearCanvas", 1);
      registerFunction("handleMouseDown", 2);
      registerFunction("handleMouseUp", 3);
      registerFunction("updateMaus", 4);
      registerFunction("refreshCanvas", 5);
      registerFunction("initCanvas", 6);
      registerFunction("resizeCanvas", 7);
      registerFunction("dragMode", 8);
      registerFunction("drawTransitionMode", 9);
      registerFunction("addState", 10);
      registerFunction("decreaseStates", 11);
    }
    @Override public void setValue(Data data, int type, Object value) {
      switch (type) {
        case 0: TYPE.replaceValue(data.getStates(), StateTupel.class, value); return;
        case 1: data.setXCoord(TYPE.extractValue(java.lang.Integer.class, value)); return;
        case 2: data.setYCoord(TYPE.extractValue(java.lang.Integer.class, value)); return;
        case 3: data.setMode(TYPE.extractValue(java.lang.String.class, value)); return;
        case 4: data.setDisplayString(TYPE.extractValue(java.lang.String.class, value)); return;
      }
      throw new UnsupportedOperationException();
    }
    @Override public Object getValue(Data data, int type) {
      switch (type) {
        case 0: return data.getStates();
        case 1: return data.getXCoord();
        case 2: return data.getYCoord();
        case 3: return data.getMode();
        case 4: return data.getDisplayString();
      }
      throw new UnsupportedOperationException();
    }
    @Override public void call(Data model, int type, Object data, Object ev) throws Exception {
      switch (type) {
        case 0:
          com.dukescript.demoapp.DataModel.mousePressed(model, model.proto.toNumber(ev, "realX").intValue(), model.proto.toNumber(ev, "realY").intValue());
          return;
        case 1:
          com.dukescript.demoapp.DataModel.clearCanvas();
          return;
        case 2:
          com.dukescript.demoapp.DataModel.handleMouseDown();
          return;
        case 3:
          com.dukescript.demoapp.DataModel.handleMouseUp();
          return;
        case 4:
          com.dukescript.demoapp.DataModel.updateMaus(model.proto.toNumber(ev, "realX").intValue(), model.proto.toNumber(ev, "realY").intValue());
          return;
        case 5:
          com.dukescript.demoapp.DataModel.refreshCanvas();
          return;
        case 6:
          com.dukescript.demoapp.DataModel.initCanvas();
          return;
        case 7:
          com.dukescript.demoapp.DataModel.resizeCanvas();
          return;
        case 8:
          com.dukescript.demoapp.DataModel.dragMode();
          return;
        case 9:
          com.dukescript.demoapp.DataModel.drawTransitionMode();
          return;
        case 10:
          com.dukescript.demoapp.DataModel.addState();
          return;
        case 11:
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
    Object[] ret = new Object[5];
    proto.extract(json, new String[] {
      "states",
      "xCoord",
      "yCoord",
      "mode",
      "displayString",
    }, ret);
    for (Object e : useAsArray(ret[0])) {
      this.prop_states.add(proto.read(StateTupel.class, e));
    }
    this.prop_xCoord = ret[1] == null ? 0 : (TYPE.numberValue(ret[1])).intValue();
    this.prop_yCoord = ret[2] == null ? 0 : (TYPE.numberValue(ret[2])).intValue();
    this.prop_mode = (java.lang.String)ret[3];
    this.prop_displayString = (java.lang.String)ret[4];
  }
  private static Object[] useAsArray(Object o) {
    return o instanceof Object[] ? ((Object[])o) : o == null ? new Object[0] : new Object[] { o };
  }
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append('{');
    sb.append('"').append("states").append('"').append(":");
    sb.append(TYPE.toJSON(prop_states));
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
    proto.cloneList(ret.getStates(), ctx, prop_states);
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
    if (!TYPE.isSame(prop_states, p.prop_states)) return false;
    if (!TYPE.isSame(prop_xCoord, p.prop_xCoord)) return false;
    if (!TYPE.isSame(prop_yCoord, p.prop_yCoord)) return false;
    if (!TYPE.isSame(prop_mode, p.prop_mode)) return false;
    if (!TYPE.isSame(prop_displayString, p.prop_displayString)) return false;
    return true;
  }
  public int hashCode() {
    int h = Data.class.getName().hashCode();
    h = TYPE.hashPlus(prop_states, h);
    h = TYPE.hashPlus(prop_xCoord, h);
    h = TYPE.hashPlus(prop_yCoord, h);
    h = TYPE.hashPlus(prop_mode, h);
    h = TYPE.hashPlus(prop_displayString, h);
    return h;
  }
}
