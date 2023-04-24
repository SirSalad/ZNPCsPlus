package lol.pyr.znpcsplus.npc;

import com.github.retrooper.packetevents.protocol.entity.type.EntityType;
import com.github.retrooper.packetevents.protocol.entity.type.EntityTypes;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Set;

public class NPCType {
    private final static ImmutableList<NPCType> npcTypes;

    public static List<NPCType> values() {
        return npcTypes;
    }

    private final EntityType type;
    private final Set<NPCProperty<?>> allowedProperties;

    public NPCType(EntityType type, NPCProperty<?>... allowedProperties) {
        this.type = type;
        this.allowedProperties = Set.of(allowedProperties);
    }

    public EntityType getType() {
        return type;
    }

    public Set<NPCProperty<?>> getAllowedProperties() {
        return allowedProperties;
    }

    static {
        ImmutableList.Builder<NPCType> builder = new ImmutableList.Builder<>();

        builder.add(new NPCType(EntityTypes.PLAYER, NPCProperty.SKIN));
        builder.add(new NPCType(EntityTypes.CREEPER));
        builder.add(new NPCType(EntityTypes.ZOMBIE));
        builder.add(new NPCType(EntityTypes.SKELETON));

        npcTypes = builder.build();
    }
}