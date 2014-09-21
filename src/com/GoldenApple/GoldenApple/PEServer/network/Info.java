package com.GoldenApple.GoldenApple.PEServer.network;

public final class Info {
	
    public static byte CURRENT_PROTOCOL = 18;

    public static byte LOGIN_PACKET = (byte)0x82;
    public static byte LOGIN_STATUS_PACKET = (byte)0x83;

    public static byte MESSAGE_PACKET = (byte)0x85;
    public static byte SET_TIME_PACKET = (byte)0x86;
    public static byte START_GAME_PACKET = (byte)0x87;
    public static byte ADD_MOB_PACKET = (byte)0x88;
    public static byte ADD_PLAYER_PACKET = (byte)0x89;
    public static byte REMOVE_PLAYER_PACKET = (byte)0x8a;

    public static byte ADD_ENTITY_PACKET = (byte)0x8c;
    public static byte REMOVE_ENTITY_PACKET = (byte)0x8d;
    public static byte ADD_ITEM_ENTITY_PACKET = (byte)0x8e;
    public static byte TAKE_ITEM_ENTITY_PACKET = (byte)0x8f;
    public static byte MOVE_ENTITY_PACKET = (byte)0x90;

    public static byte ROTATE_HEAD_PACKET = (byte)0x94;
    public static byte MOVE_PLAYER_PACKET = (byte)0x95;
    //public static byte PLACE_BLOCK_PACKET = (byte)0x96;
    public static byte REMOVE_BLOCK_PACKET = (byte)0x97;
    public static byte UPDATE_BLOCK_PACKET = (byte)0x98;
    public static byte ADD_PAINTING_PACKET = (byte)0x99;
    public static byte EXPLODE_PACKET = (byte)0x9a;
    public static byte LEVEL_EVENT_PACKET = (byte)0x9b;
    public static byte TILE_EVENT_PACKET = (byte)0x9c;
    public static byte ENTITY_EVENT_PACKET = (byte)0x9d;

    public static byte PLAYER_EQUIPMENT_PACKET = (byte)0xa0;
    public static byte PLAYER_ARMOR_EQUIPMENT_PACKET = (byte)0xa1;
    public static byte INTERACT_PACKET = (byte)0xa2;
    public static byte USE_ITEM_PACKET = (byte)0xa3;
    public static byte PLAYER_ACTION_PACKET = (byte)0xa4;

    public static byte HURT_ARMOR_PACKET = (byte)0xa6;
    public static byte SET_ENTITY_DATA_PACKET = (byte)0xa7;
    public static byte SET_ENTITY_MOTION_PACKET = (byte)0xa8;
    //public static byte SET_ENTITY_LINK_PACKET = (byte)0xa9;
    public static byte SET_HEALTH_PACKET = (byte)0xaa;
    public static byte SET_SPAWN_POSITION_PACKET = (byte)0xab;
    public static byte ANIMATE_PACKET = (byte)0xac;
    public static byte RESPAWN_PACKET = (byte)0xad;
    public static byte SEND_INVENTORY_PACKET = (byte)0xae;
    public static byte DROP_ITEM_PACKET = (byte)0xaf;
    public static byte CONTAINER_OPEN_PACKET = (byte)0xb0;
    public static byte CONTAINER_CLOSE_PACKET = (byte)0xb1;
    public static byte CONTAINER_SET_SLOT_PACKET = (byte)0xb2;
    public static byte CONTAINER_SET_DATA_PACKET = (byte)0xb3;
    public static byte CONTAINER_SET_CONTENT_PACKET = (byte)0xb4;
    //public static byte CONTAINER_ACK_PACKET = (byte)0xb5;
    public static byte CHAT_PACKET = (byte)0xb6;
    public static byte ADVENTURE_SETTINGS_PACKET = (byte)0xb7;
    public static byte ENTITY_DATA_PACKET = (byte)0xb8;
    //public static byte PLAYER_INPUT_PACKET = (byte)0xb9;
    public static byte FULL_CHUNK_DATA_PACKET = (byte)0xba;
    public static byte UNLOAD_CHUNK_PACKET = (byte)0xbb;
    
}
