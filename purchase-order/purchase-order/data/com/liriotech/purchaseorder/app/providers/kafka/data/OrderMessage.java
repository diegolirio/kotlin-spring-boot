/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.liriotech.purchaseorder.app.providers.kafka.data;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class OrderMessage extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2855961277628209857L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OrderMessage\",\"namespace\":\"com.liriotech.purchaseorder.app.providers.kafka.data\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"customerId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"productCode\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"value\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\",\"java-class\":\"java.math.BigDecimal\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<OrderMessage> ENCODER =
      new BinaryMessageEncoder<OrderMessage>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<OrderMessage> DECODER =
      new BinaryMessageDecoder<OrderMessage>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<OrderMessage> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<OrderMessage> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<OrderMessage> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<OrderMessage>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this OrderMessage to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a OrderMessage from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a OrderMessage instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static OrderMessage fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String id;
  @Deprecated public java.lang.String customerId;
  @Deprecated public java.lang.String productCode;
  @Deprecated public java.math.BigDecimal value;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public OrderMessage() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param customerId The new value for customerId
   * @param productCode The new value for productCode
   * @param value The new value for value
   */
  public OrderMessage(java.lang.String id, java.lang.String customerId, java.lang.String productCode, java.math.BigDecimal value) {
    this.id = id;
    this.customerId = customerId;
    this.productCode = productCode;
    this.value = value;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return customerId;
    case 2: return productCode;
    case 3: return value;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = value$ != null ? value$.toString() : null; break;
    case 1: customerId = value$ != null ? value$.toString() : null; break;
    case 2: productCode = value$ != null ? value$.toString() : null; break;
    case 3: value = (java.math.BigDecimal)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.String getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'customerId' field.
   * @return The value of the 'customerId' field.
   */
  public java.lang.String getCustomerId() {
    return customerId;
  }


  /**
   * Sets the value of the 'customerId' field.
   * @param value the value to set.
   */
  public void setCustomerId(java.lang.String value) {
    this.customerId = value;
  }

  /**
   * Gets the value of the 'productCode' field.
   * @return The value of the 'productCode' field.
   */
  public java.lang.String getProductCode() {
    return productCode;
  }


  /**
   * Sets the value of the 'productCode' field.
   * @param value the value to set.
   */
  public void setProductCode(java.lang.String value) {
    this.productCode = value;
  }

  /**
   * Gets the value of the 'value' field.
   * @return The value of the 'value' field.
   */
  public java.math.BigDecimal getValue() {
    return value;
  }


  /**
   * Sets the value of the 'value' field.
   * @param value the value to set.
   */
  public void setValue(java.math.BigDecimal value) {
    this.value = value;
  }

  /**
   * Creates a new OrderMessage RecordBuilder.
   * @return A new OrderMessage RecordBuilder
   */
  public static com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder newBuilder() {
    return new com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder();
  }

  /**
   * Creates a new OrderMessage RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new OrderMessage RecordBuilder
   */
  public static com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder newBuilder(com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder other) {
    if (other == null) {
      return new com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder();
    } else {
      return new com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder(other);
    }
  }

  /**
   * Creates a new OrderMessage RecordBuilder by copying an existing OrderMessage instance.
   * @param other The existing instance to copy.
   * @return A new OrderMessage RecordBuilder
   */
  public static com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder newBuilder(com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage other) {
    if (other == null) {
      return new com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder();
    } else {
      return new com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder(other);
    }
  }

  /**
   * RecordBuilder for OrderMessage instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OrderMessage>
    implements org.apache.avro.data.RecordBuilder<OrderMessage> {

    private java.lang.String id;
    private java.lang.String customerId;
    private java.lang.String productCode;
    private java.math.BigDecimal value;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.customerId)) {
        this.customerId = data().deepCopy(fields()[1].schema(), other.customerId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.productCode)) {
        this.productCode = data().deepCopy(fields()[2].schema(), other.productCode);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.value)) {
        this.value = data().deepCopy(fields()[3].schema(), other.value);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing OrderMessage instance
     * @param other The existing instance to copy.
     */
    private Builder(com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.customerId)) {
        this.customerId = data().deepCopy(fields()[1].schema(), other.customerId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.productCode)) {
        this.productCode = data().deepCopy(fields()[2].schema(), other.productCode);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.value)) {
        this.value = data().deepCopy(fields()[3].schema(), other.value);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.String getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder setId(java.lang.String value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'customerId' field.
      * @return The value.
      */
    public java.lang.String getCustomerId() {
      return customerId;
    }


    /**
      * Sets the value of the 'customerId' field.
      * @param value The value of 'customerId'.
      * @return This builder.
      */
    public com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder setCustomerId(java.lang.String value) {
      validate(fields()[1], value);
      this.customerId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'customerId' field has been set.
      * @return True if the 'customerId' field has been set, false otherwise.
      */
    public boolean hasCustomerId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'customerId' field.
      * @return This builder.
      */
    public com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder clearCustomerId() {
      customerId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'productCode' field.
      * @return The value.
      */
    public java.lang.String getProductCode() {
      return productCode;
    }


    /**
      * Sets the value of the 'productCode' field.
      * @param value The value of 'productCode'.
      * @return This builder.
      */
    public com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder setProductCode(java.lang.String value) {
      validate(fields()[2], value);
      this.productCode = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'productCode' field has been set.
      * @return True if the 'productCode' field has been set, false otherwise.
      */
    public boolean hasProductCode() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'productCode' field.
      * @return This builder.
      */
    public com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder clearProductCode() {
      productCode = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'value' field.
      * @return The value.
      */
    public java.math.BigDecimal getValue() {
      return value;
    }


    /**
      * Sets the value of the 'value' field.
      * @param value The value of 'value'.
      * @return This builder.
      */
    public com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder setValue(java.math.BigDecimal value) {
      validate(fields()[3], value);
      this.value = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'value' field has been set.
      * @return True if the 'value' field has been set, false otherwise.
      */
    public boolean hasValue() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'value' field.
      * @return This builder.
      */
    public com.liriotech.purchaseorder.app.providers.kafka.data.OrderMessage.Builder clearValue() {
      value = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public OrderMessage build() {
      try {
        OrderMessage record = new OrderMessage();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.customerId = fieldSetFlags()[1] ? this.customerId : (java.lang.String) defaultValue(fields()[1]);
        record.productCode = fieldSetFlags()[2] ? this.productCode : (java.lang.String) defaultValue(fields()[2]);
        record.value = fieldSetFlags()[3] ? this.value : (java.math.BigDecimal) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<OrderMessage>
    WRITER$ = (org.apache.avro.io.DatumWriter<OrderMessage>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<OrderMessage>
    READER$ = (org.apache.avro.io.DatumReader<OrderMessage>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.id);

    out.writeString(this.customerId);

    out.writeString(this.productCode);

    out.writeString(this.value.toString());

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readString();

      this.customerId = in.readString();

      this.productCode = in.readString();

      this.value = new java.math.BigDecimal(in.readString());

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readString();
          break;

        case 1:
          this.customerId = in.readString();
          break;

        case 2:
          this.productCode = in.readString();
          break;

        case 3:
          this.value = new java.math.BigDecimal(in.readString());
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










