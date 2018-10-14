// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Bank.proto

package rpc;

/**
 * Protobuf type {@code rpc.UserCustomerLogsReply}
 */
public final class UserCustomerLogsReply extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:rpc.UserCustomerLogsReply)
        UserCustomerLogsReplyOrBuilder {
    public static final int TRANS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0L;
    // @@protoc_insertion_point(class_scope:rpc.UserCustomerLogsReply)
    private static final UserCustomerLogsReply DEFAULT_INSTANCE;
    private static final com.google.protobuf.Parser<UserCustomerLogsReply>
            PARSER = new com.google.protobuf.AbstractParser<UserCustomerLogsReply>() {
        public UserCustomerLogsReply parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new UserCustomerLogsReply(input, extensionRegistry);
        }
    };

    static {
        DEFAULT_INSTANCE = new UserCustomerLogsReply();
    }

    private java.util.List<UserCustomerLog> trans_;
    private byte memoizedIsInitialized = -1;

    // Use UserCustomerLogsReply.newBuilder() to construct.
    private UserCustomerLogsReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private UserCustomerLogsReply() {
        trans_ = java.util.Collections.emptyList();
    }

    private UserCustomerLogsReply(
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
                        if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                            trans_ = new java.util.ArrayList<UserCustomerLog>();
                            mutable_bitField0_ |= 0x00000001;
                        }
                        trans_.add(
                                input.readMessage(UserCustomerLog.parser(), extensionRegistry));
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
            if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                trans_ = java.util.Collections.unmodifiableList(trans_);
            }
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor
    getDescriptor() {
        return BankProto.internal_static_rpc_UserCustomerLogsReply_descriptor;
    }

    public static UserCustomerLogsReply parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static UserCustomerLogsReply parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static UserCustomerLogsReply parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static UserCustomerLogsReply parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static UserCustomerLogsReply parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static UserCustomerLogsReply parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static UserCustomerLogsReply parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static UserCustomerLogsReply parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static UserCustomerLogsReply parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static UserCustomerLogsReply parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static UserCustomerLogsReply parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static UserCustomerLogsReply parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(UserCustomerLogsReply prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static UserCustomerLogsReply getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<UserCustomerLogsReply> parser() {
        return PARSER;
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
        return this.unknownFields;
    }

    protected FieldAccessorTable
    internalGetFieldAccessorTable() {
        return BankProto.internal_static_rpc_UserCustomerLogsReply_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        UserCustomerLogsReply.class, UserCustomerLogsReply.Builder.class);
    }

    /**
     * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
     */
    public java.util.List<UserCustomerLog> getTransList() {
        return trans_;
    }

    /**
     * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
     */
    public java.util.List<? extends UserCustomerLogOrBuilder>
    getTransOrBuilderList() {
        return trans_;
    }

    /**
     * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
     */
    public int getTransCount() {
        return trans_.size();
    }

    /**
     * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
     */
    public UserCustomerLog getTrans(int index) {
        return trans_.get(index);
    }

    /**
     * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
     */
    public UserCustomerLogOrBuilder getTransOrBuilder(
            int index) {
        return trans_.get(index);
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
        for (int i = 0; i < trans_.size(); i++) {
            output.writeMessage(1, trans_.get(i));
        }
        unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) return size;

        size = 0;
        for (int i = 0; i < trans_.size(); i++) {
            size += com.google.protobuf.CodedOutputStream
                    .computeMessageSize(1, trans_.get(i));
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
        if (!(obj instanceof UserCustomerLogsReply)) {
            return super.equals(obj);
        }
        UserCustomerLogsReply other = (UserCustomerLogsReply) obj;

        boolean result = true;
        result = result && getTransList()
                .equals(other.getTransList());
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
        if (getTransCount() > 0) {
            hash = (37 * hash) + TRANS_FIELD_NUMBER;
            hash = (53 * hash) + getTransList().hashCode();
        }
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
    public com.google.protobuf.Parser<UserCustomerLogsReply> getParserForType() {
        return PARSER;
    }

    public UserCustomerLogsReply getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    /**
     * Protobuf type {@code rpc.UserCustomerLogsReply}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:rpc.UserCustomerLogsReply)
            UserCustomerLogsReplyOrBuilder {
        private int bitField0_;
        private java.util.List<UserCustomerLog> trans_ =
                java.util.Collections.emptyList();
        private com.google.protobuf.RepeatedFieldBuilderV3<
                UserCustomerLog, UserCustomerLog.Builder, UserCustomerLogOrBuilder> transBuilder_;

        // Construct using rpc.UserCustomerLogsReply.newBuilder()
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
            return BankProto.internal_static_rpc_UserCustomerLogsReply_descriptor;
        }

        protected FieldAccessorTable
        internalGetFieldAccessorTable() {
            return BankProto.internal_static_rpc_UserCustomerLogsReply_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            UserCustomerLogsReply.class, UserCustomerLogsReply.Builder.class);
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3
                    .alwaysUseFieldBuilders) {
                getTransFieldBuilder();
            }
        }

        public Builder clear() {
            super.clear();
            if (transBuilder_ == null) {
                trans_ = java.util.Collections.emptyList();
                bitField0_ = (bitField0_ & ~0x00000001);
            } else {
                transBuilder_.clear();
            }
            return this;
        }

        public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
            return BankProto.internal_static_rpc_UserCustomerLogsReply_descriptor;
        }

        public UserCustomerLogsReply getDefaultInstanceForType() {
            return UserCustomerLogsReply.getDefaultInstance();
        }

        public UserCustomerLogsReply build() {
            UserCustomerLogsReply result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        public UserCustomerLogsReply buildPartial() {
            UserCustomerLogsReply result = new UserCustomerLogsReply(this);
            int from_bitField0_ = bitField0_;
            if (transBuilder_ == null) {
                if (((bitField0_ & 0x00000001) == 0x00000001)) {
                    trans_ = java.util.Collections.unmodifiableList(trans_);
                    bitField0_ = (bitField0_ & ~0x00000001);
                }
                result.trans_ = trans_;
            } else {
                result.trans_ = transBuilder_.build();
            }
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
            if (other instanceof UserCustomerLogsReply) {
                return mergeFrom((UserCustomerLogsReply) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(UserCustomerLogsReply other) {
            if (other == UserCustomerLogsReply.getDefaultInstance()) return this;
            if (transBuilder_ == null) {
                if (!other.trans_.isEmpty()) {
                    if (trans_.isEmpty()) {
                        trans_ = other.trans_;
                        bitField0_ = (bitField0_ & ~0x00000001);
                    } else {
                        ensureTransIsMutable();
                        trans_.addAll(other.trans_);
                    }
                    onChanged();
                }
            } else {
                if (!other.trans_.isEmpty()) {
                    if (transBuilder_.isEmpty()) {
                        transBuilder_.dispose();
                        transBuilder_ = null;
                        trans_ = other.trans_;
                        bitField0_ = (bitField0_ & ~0x00000001);
                        transBuilder_ =
                                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                                        getTransFieldBuilder() : null;
                    } else {
                        transBuilder_.addAllMessages(other.trans_);
                    }
                }
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
            UserCustomerLogsReply parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (UserCustomerLogsReply) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private void ensureTransIsMutable() {
            if (!((bitField0_ & 0x00000001) == 0x00000001)) {
                trans_ = new java.util.ArrayList<UserCustomerLog>(trans_);
                bitField0_ |= 0x00000001;
            }
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public java.util.List<UserCustomerLog> getTransList() {
            if (transBuilder_ == null) {
                return java.util.Collections.unmodifiableList(trans_);
            } else {
                return transBuilder_.getMessageList();
            }
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public int getTransCount() {
            if (transBuilder_ == null) {
                return trans_.size();
            } else {
                return transBuilder_.getCount();
            }
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public UserCustomerLog getTrans(int index) {
            if (transBuilder_ == null) {
                return trans_.get(index);
            } else {
                return transBuilder_.getMessage(index);
            }
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public Builder setTrans(
                int index, UserCustomerLog value) {
            if (transBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureTransIsMutable();
                trans_.set(index, value);
                onChanged();
            } else {
                transBuilder_.setMessage(index, value);
            }
            return this;
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public Builder setTrans(
                int index, UserCustomerLog.Builder builderForValue) {
            if (transBuilder_ == null) {
                ensureTransIsMutable();
                trans_.set(index, builderForValue.build());
                onChanged();
            } else {
                transBuilder_.setMessage(index, builderForValue.build());
            }
            return this;
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public Builder addTrans(UserCustomerLog value) {
            if (transBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureTransIsMutable();
                trans_.add(value);
                onChanged();
            } else {
                transBuilder_.addMessage(value);
            }
            return this;
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public Builder addTrans(
                int index, UserCustomerLog value) {
            if (transBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureTransIsMutable();
                trans_.add(index, value);
                onChanged();
            } else {
                transBuilder_.addMessage(index, value);
            }
            return this;
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public Builder addTrans(
                UserCustomerLog.Builder builderForValue) {
            if (transBuilder_ == null) {
                ensureTransIsMutable();
                trans_.add(builderForValue.build());
                onChanged();
            } else {
                transBuilder_.addMessage(builderForValue.build());
            }
            return this;
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public Builder addTrans(
                int index, UserCustomerLog.Builder builderForValue) {
            if (transBuilder_ == null) {
                ensureTransIsMutable();
                trans_.add(index, builderForValue.build());
                onChanged();
            } else {
                transBuilder_.addMessage(index, builderForValue.build());
            }
            return this;
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public Builder addAllTrans(
                Iterable<? extends UserCustomerLog> values) {
            if (transBuilder_ == null) {
                ensureTransIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll(
                        values, trans_);
                onChanged();
            } else {
                transBuilder_.addAllMessages(values);
            }
            return this;
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public Builder clearTrans() {
            if (transBuilder_ == null) {
                trans_ = java.util.Collections.emptyList();
                bitField0_ = (bitField0_ & ~0x00000001);
                onChanged();
            } else {
                transBuilder_.clear();
            }
            return this;
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public Builder removeTrans(int index) {
            if (transBuilder_ == null) {
                ensureTransIsMutable();
                trans_.remove(index);
                onChanged();
            } else {
                transBuilder_.remove(index);
            }
            return this;
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public UserCustomerLog.Builder getTransBuilder(
                int index) {
            return getTransFieldBuilder().getBuilder(index);
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public UserCustomerLogOrBuilder getTransOrBuilder(
                int index) {
            if (transBuilder_ == null) {
                return trans_.get(index);
            } else {
                return transBuilder_.getMessageOrBuilder(index);
            }
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public java.util.List<? extends UserCustomerLogOrBuilder>
        getTransOrBuilderList() {
            if (transBuilder_ != null) {
                return transBuilder_.getMessageOrBuilderList();
            } else {
                return java.util.Collections.unmodifiableList(trans_);
            }
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public UserCustomerLog.Builder addTransBuilder() {
            return getTransFieldBuilder().addBuilder(
                    UserCustomerLog.getDefaultInstance());
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public UserCustomerLog.Builder addTransBuilder(
                int index) {
            return getTransFieldBuilder().addBuilder(
                    index, UserCustomerLog.getDefaultInstance());
        }

        /**
         * <code>repeated .rpc.UserCustomerLog trans = 1;</code>
         */
        public java.util.List<UserCustomerLog.Builder>
        getTransBuilderList() {
            return getTransFieldBuilder().getBuilderList();
        }

        private com.google.protobuf.RepeatedFieldBuilderV3<
                UserCustomerLog, UserCustomerLog.Builder, UserCustomerLogOrBuilder>
        getTransFieldBuilder() {
            if (transBuilder_ == null) {
                transBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                        UserCustomerLog, UserCustomerLog.Builder, UserCustomerLogOrBuilder>(
                        trans_,
                        ((bitField0_ & 0x00000001) == 0x00000001),
                        getParentForChildren(),
                        isClean());
                trans_ = null;
            }
            return transBuilder_;
        }

        public final Builder setUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.setUnknownFieldsProto3(unknownFields);
        }

        public final Builder mergeUnknownFields(
                final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:rpc.UserCustomerLogsReply)
  }

}
