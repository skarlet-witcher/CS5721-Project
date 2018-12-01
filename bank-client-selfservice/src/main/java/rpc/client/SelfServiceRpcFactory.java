package rpc.client;

import Const.ClientRpcType;

public class SelfServiceRpcFactory {
    public static ClientRpc getClientRpc(ClientRpcType type) throws Exception {
        switch (type) {
            case CustomerApplyRpc:
                return CustomerApplyRpc.getInstance();
            case CustomerMainRpc:
                return CustomerMainRpc.getInstance();
            case CustomerLoginRpc:
                return CustomerLoginRpc.getInstance();
            case CustomerPayeeRpc:
                return CustomerPayeeRpc.getInstance();
        }
        return null;
    }
}
