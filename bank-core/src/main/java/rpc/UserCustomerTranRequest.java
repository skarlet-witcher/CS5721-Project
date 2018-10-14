// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Bank.proto

package rpc;

/**
 * Protobuf type {@code rpc.UserCustomerTranRequest}
 */
public final class UserCustomerTranRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:rpc.UserCustomerTranRequest)
        UserCustomerTranRequestOrBuilder {
  public static final int USER_ID_FIELD_NUMBER = 1;
  public static final int TO_CARD_NO_FIELD_NUMBER = 2;
  public static final int AMOUNT_FIELD_NUMBER = 3;
  public static final int CURRENCY_FIELD_NUMBER = 4;
  public static final int DESCRIPTION_FIELD_NUMBER = 5;
  private static final long serialVersionUID = 0L;
  // @@protoc_insertion_point(class_scope:rpc.UserCustomerTranRequest)
  private static final UserCustomerTranRequest DEFAULT_INSTANCE;
  private static final com.google.protobuf.Parser<UserCustomerTranRequest>
          PARSER = new com.google.protobuf.AbstractParser<UserCustomerTranRequest>() {
    public UserCustomerTranRequest parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return new UserCustomerTranRequest(input, extensionRegistry);
    }
  };

  static {
    DEFAULT_INSTANCE = new UserCustomerTranRequest();
  }

  private volatile Object userId_;
  private volatile Object toCardNo_;
  private volatile Object amount_;
  private volatile Object currency_;
  private volatile Object description_;
  private byte memoizedIsInitialized = -1;

  // Use UserCustomerTranRequest.newBuilder() to construct.
  private UserCustomerTranRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private UserCustomerTranRequest() {
    userId_ = "";
    toCardNo_ = "";
    amount_ = "";
    currency_ = "";
    description_ = "";
  }

  private UserCustomerTranRequest(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
            com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                    input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            String s = input.readStringRequireUtf8();

            userId_ = s;
            break;
          }
          case 18: {
            String s = input.readStringRequireUtf8();

            toCardNo_ = s;
            break;
          }
          case 26: {
            String s = input.readStringRequireUtf8();

            amount_ = s;
            break;
          }
          case 34: {
            String s = input.readStringRequireUtf8();

            currency_ = s;
            break;
          }
          case 42: {
            String s = input.readStringRequireUtf8();

            description_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
              e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor
  getDescriptor() {
    return BankProto.internal_static_rpc_UserCustomerTranRequest_descriptor;
  }

  public static UserCustomerTranRequest parseFrom(
          java.nio.ByteBuffer data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static UserCustomerTranRequest parseFrom(
          java.nio.ByteBuffer data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static UserCustomerTranRequest parseFrom(
          com.google.protobuf.ByteString data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static UserCustomerTranRequest parseFrom(
          com.google.protobuf.ByteString data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static UserCustomerTranRequest parseFrom(byte[] data)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static UserCustomerTranRequest parseFrom(
          byte[] data,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static UserCustomerTranRequest parseFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static UserCustomerTranRequest parseFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static UserCustomerTranRequest parseDelimitedFrom(java.io.InputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input);
  }

  public static UserCustomerTranRequest parseDelimitedFrom(
          java.io.InputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }

  public static UserCustomerTranRequest parseFrom(
          com.google.protobuf.CodedInputStream input)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input);
  }

  public static UserCustomerTranRequest parseFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
            .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(UserCustomerTranRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public static UserCustomerTranRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  public static com.google.protobuf.Parser<UserCustomerTranRequest> parser() {
    return PARSER;
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }

  protected FieldAccessorTable
  internalGetFieldAccessorTable() {
    return BankProto.internal_static_rpc_UserCustomerTranRequest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                    UserCustomerTranRequest.class, UserCustomerTranRequest.Builder.class);
  }

  /**
   * <code>string user_id = 1;</code>
   */
  public String getUserId() {
    Object ref = userId_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      userId_ = s;
      return s;
    }
  }

  /**
   * <code>string user_id = 1;</code>
   */
  public com.google.protobuf.ByteString
  getUserIdBytes() {
    Object ref = userId_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                      (String) ref);
      userId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  /**
   * <code>string to_card_no = 2;</code>
   */
  public String getToCardNo() {
    Object ref = toCardNo_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      toCardNo_ = s;
      return s;
    }
  }

  /**
   * <code>string to_card_no = 2;</code>
   */
  public com.google.protobuf.ByteString
  getToCardNoBytes() {
    Object ref = toCardNo_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                      (String) ref);
      toCardNo_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  /**
   * <code>string amount = 3;</code>
   */
  public String getAmount() {
    Object ref = amount_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      amount_ = s;
      return s;
    }
  }

  /**
   * <code>string amount = 3;</code>
   */
  public com.google.protobuf.ByteString
  getAmountBytes() {
    Object ref = amount_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                      (String) ref);
      amount_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  /**
   * <code>string currency = 4;</code>
   */
  public String getCurrency() {
    Object ref = currency_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      currency_ = s;
      return s;
    }
  }

  /**
   * <code>string currency = 4;</code>
   */
  public com.google.protobuf.ByteString
  getCurrencyBytes() {
    Object ref = currency_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                      (String) ref);
      currency_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  /**
   * <code>string description = 5;</code>
   */
  public String getDescription() {
    Object ref = description_;
    if (ref instanceof String) {
      return (String) ref;
    } else {
      com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
      String s = bs.toStringUtf8();
      description_ = s;
      return s;
    }
  }

  /**
   * <code>string description = 5;</code>
   */
  public com.google.protobuf.ByteString
  getDescriptionBytes() {
    Object ref = description_;
    if (ref instanceof String) {
      com.google.protobuf.ByteString b =
              com.google.protobuf.ByteString.copyFromUtf8(
                      (String) ref);
      description_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
          throws java.io.IOException {
    if (!getUserIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, userId_);
    }
    if (!getToCardNoBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, toCardNo_);
    }
    if (!getAmountBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, amount_);
    }
    if (!getCurrencyBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, currency_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, description_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getUserIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, userId_);
    }
    if (!getToCardNoBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, toCardNo_);
    }
    if (!getAmountBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, amount_);
    }
    if (!getCurrencyBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, currency_);
    }
    if (!getDescriptionBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, description_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof UserCustomerTranRequest)) {
      return super.equals(obj);
    }
    UserCustomerTranRequest other = (UserCustomerTranRequest) obj;

    boolean result = true;
    result = result && getUserId()
            .equals(other.getUserId());
    result = result && getToCardNo()
            .equals(other.getToCardNo());
    result = result && getAmount()
            .equals(other.getAmount());
    result = result && getCurrency()
            .equals(other.getCurrency());
    result = result && getDescription()
            .equals(other.getDescription());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + USER_ID_FIELD_NUMBER;
    hash = (53 * hash) + getUserId().hashCode();
    hash = (37 * hash) + TO_CARD_NO_FIELD_NUMBER;
    hash = (53 * hash) + getToCardNo().hashCode();
    hash = (37 * hash) + AMOUNT_FIELD_NUMBER;
    hash = (53 * hash) + getAmount().hashCode();
    hash = (37 * hash) + CURRENCY_FIELD_NUMBER;
    hash = (53 * hash) + getCurrency().hashCode();
    hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
    hash = (53 * hash) + getDescription().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public Builder newBuilderForType() {
    return newBuilder();
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
            ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
          BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }

  @Override
  public com.google.protobuf.Parser<UserCustomerTranRequest> getParserForType() {
    return PARSER;
  }

  public UserCustomerTranRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

  /**
   * Protobuf type {@code rpc.UserCustomerTranRequest}
   */
  public static final class Builder extends
          com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
          // @@protoc_insertion_point(builder_implements:rpc.UserCustomerTranRequest)
          UserCustomerTranRequestOrBuilder {
    private Object userId_ = "";
    private Object toCardNo_ = "";
    private Object amount_ = "";
    private Object currency_ = "";
    private Object description_ = "";

    // Construct using rpc.UserCustomerTranRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
            BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
      return BankProto.internal_static_rpc_UserCustomerTranRequest_descriptor;
    }

    protected FieldAccessorTable
    internalGetFieldAccessorTable() {
      return BankProto.internal_static_rpc_UserCustomerTranRequest_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      UserCustomerTranRequest.class, UserCustomerTranRequest.Builder.class);
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }

    public Builder clear() {
      super.clear();
      userId_ = "";

      toCardNo_ = "";

      amount_ = "";

      currency_ = "";

      description_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
    getDescriptorForType() {
      return BankProto.internal_static_rpc_UserCustomerTranRequest_descriptor;
    }

    public UserCustomerTranRequest getDefaultInstanceForType() {
      return UserCustomerTranRequest.getDefaultInstance();
    }

    public UserCustomerTranRequest build() {
      UserCustomerTranRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public UserCustomerTranRequest buildPartial() {
      UserCustomerTranRequest result = new UserCustomerTranRequest(this);
      result.userId_ = userId_;
      result.toCardNo_ = toCardNo_;
      result.amount_ = amount_;
      result.currency_ = currency_;
      result.description_ = description_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return super.clone();
    }

    public Builder setField(
            com.google.protobuf.Descriptors.FieldDescriptor field,
            Object value) {
      return super.setField(field, value);
    }

    public Builder clearField(
            com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    public Builder clearOneof(
            com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    public Builder setRepeatedField(
            com.google.protobuf.Descriptors.FieldDescriptor field,
            int index, Object value) {
      return super.setRepeatedField(field, index, value);
    }

    public Builder addRepeatedField(
            com.google.protobuf.Descriptors.FieldDescriptor field,
            Object value) {
      return super.addRepeatedField(field, value);
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof UserCustomerTranRequest) {
        return mergeFrom((UserCustomerTranRequest) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(UserCustomerTranRequest other) {
      if (other == UserCustomerTranRequest.getDefaultInstance()) return this;
      if (!other.getUserId().isEmpty()) {
        userId_ = other.userId_;
        onChanged();
      }
      if (!other.getToCardNo().isEmpty()) {
        toCardNo_ = other.toCardNo_;
        onChanged();
      }
      if (!other.getAmount().isEmpty()) {
        amount_ = other.amount_;
        onChanged();
      }
      if (!other.getCurrency().isEmpty()) {
        currency_ = other.currency_;
        onChanged();
      }
      if (!other.getDescription().isEmpty()) {
        description_ = other.description_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      UserCustomerTranRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (UserCustomerTranRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    /**
     * <code>string user_id = 1;</code>
     */
    public String getUserId() {
      Object ref = userId_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        userId_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }

    /**
     * <code>string user_id = 1;</code>
     */
    public Builder setUserId(
            String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      userId_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>string user_id = 1;</code>
     */
    public com.google.protobuf.ByteString
    getUserIdBytes() {
      Object ref = userId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
                com.google.protobuf.ByteString.copyFromUtf8(
                        (String) ref);
        userId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    /**
     * <code>string user_id = 1;</code>
     */
    public Builder setUserIdBytes(
            com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      userId_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>string user_id = 1;</code>
     */
    public Builder clearUserId() {

      userId_ = getDefaultInstance().getUserId();
      onChanged();
      return this;
    }

    /**
     * <code>string to_card_no = 2;</code>
     */
    public String getToCardNo() {
      Object ref = toCardNo_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        toCardNo_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }

    /**
     * <code>string to_card_no = 2;</code>
     */
    public Builder setToCardNo(
            String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      toCardNo_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>string to_card_no = 2;</code>
     */
    public com.google.protobuf.ByteString
    getToCardNoBytes() {
      Object ref = toCardNo_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
                com.google.protobuf.ByteString.copyFromUtf8(
                        (String) ref);
        toCardNo_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    /**
     * <code>string to_card_no = 2;</code>
     */
    public Builder setToCardNoBytes(
            com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      toCardNo_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>string to_card_no = 2;</code>
     */
    public Builder clearToCardNo() {

      toCardNo_ = getDefaultInstance().getToCardNo();
      onChanged();
      return this;
    }

    /**
     * <code>string amount = 3;</code>
     */
    public String getAmount() {
      Object ref = amount_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        amount_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }

    /**
     * <code>string amount = 3;</code>
     */
    public Builder setAmount(
            String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      amount_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>string amount = 3;</code>
     */
    public com.google.protobuf.ByteString
    getAmountBytes() {
      Object ref = amount_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
                com.google.protobuf.ByteString.copyFromUtf8(
                        (String) ref);
        amount_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    /**
     * <code>string amount = 3;</code>
     */
    public Builder setAmountBytes(
            com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      amount_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>string amount = 3;</code>
     */
    public Builder clearAmount() {

      amount_ = getDefaultInstance().getAmount();
      onChanged();
      return this;
    }

    /**
     * <code>string currency = 4;</code>
     */
    public String getCurrency() {
      Object ref = currency_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        currency_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }

    /**
     * <code>string currency = 4;</code>
     */
    public Builder setCurrency(
            String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      currency_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>string currency = 4;</code>
     */
    public com.google.protobuf.ByteString
    getCurrencyBytes() {
      Object ref = currency_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
                com.google.protobuf.ByteString.copyFromUtf8(
                        (String) ref);
        currency_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    /**
     * <code>string currency = 4;</code>
     */
    public Builder setCurrencyBytes(
            com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      currency_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>string currency = 4;</code>
     */
    public Builder clearCurrency() {

      currency_ = getDefaultInstance().getCurrency();
      onChanged();
      return this;
    }

    /**
     * <code>string description = 5;</code>
     */
    public String getDescription() {
      Object ref = description_;
      if (!(ref instanceof String)) {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        description_ = s;
        return s;
      } else {
        return (String) ref;
      }
    }

    /**
     * <code>string description = 5;</code>
     */
    public Builder setDescription(
            String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      description_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>string description = 5;</code>
     */
    public com.google.protobuf.ByteString
    getDescriptionBytes() {
      Object ref = description_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
                com.google.protobuf.ByteString.copyFromUtf8(
                        (String) ref);
        description_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    /**
     * <code>string description = 5;</code>
     */
    public Builder setDescriptionBytes(
            com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);

      description_ = value;
      onChanged();
      return this;
    }

    /**
     * <code>string description = 5;</code>
     */
    public Builder clearDescription() {

      description_ = getDefaultInstance().getDescription();
      onChanged();
      return this;
    }

    public final Builder setUnknownFields(
            final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
            final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:rpc.UserCustomerTranRequest)
  }

}
