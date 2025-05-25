val players by server.players
val player = players().first()

val modium by NPCEntity.creating {
    name = "Модиум" //Имя персонажа
    model = "is:models/npc/modium.gltf" //Путь к модели персонажа
    attributes = Attributes( //список атрибутов персонажа (здоровье, скорость и т.п.) - всё как в команде /attribute
        "minecraft:generic.max_health" to 10000f,
        "minecraft:generic.movement_speed" to 0.4f, //к примеру здоровье
    )
    animations[AnimationType.IDLE] = "modium"
    animations[AnimationType.WALK] = "walk"
    showName = true //показывать ли ник с именем над нпс
    pos = pos(-1531.54, 291.06, -206.78) //координаты где спавнить нпс
}

execute{"/effect give @e[type=hollowengine:npc_entity] minecraft:regeneration 255 255 true"}
wait{1.sec}
execute{"/effect clear @e[type=hollowengine:npc_entity]"}

modium lookAt {player}

//modium moveAlwaysTo {player}
var modium_is_alive = true

var npcEntity = NPCEntity(player.level)
next {
 npcEntity = modium.invoke()!!
}


While ({modium_is_alive})
{
	wait{1.sec}
	val a = npcEntity.getHealth().toString()
	execute{"/say "+a.toString()}
	if (a.toFloat()<19f)
	{
		modium_is_alive=false
		modium.clearTarget()
		execute{"/say END"}
	}
	else
	{
	
	}
		
}


/*async{While ({modium_is_alive}){
execute{"/say "+npcEntity.getHealth().toString()}
	modium setTarget{player}
	wait{15.sec}
	modium.clearTarget()
	modium moveTo {pos(-1531.54, 291.06, -206.78)}
execute{"/say "+npcEntity.getHealth().toString()}
	modium setTarget{player}
	wait{15.sec}
	modium.clearTarget()
	modium moveTo {pos(-1546.70, 292.00, -194.44)}
execute{"/say "+npcEntity.getHealth().toString()}
	modium setTarget{player}
	wait{15.sec}
	modium.clearTarget()
	modium moveTo {pos(-1514.41, 291.00, -213.36)}
execute{"/say "+npcEntity.getHealth().toString()}
	modium setTarget{player}
	wait{15.sec}
	modium.clearTarget()
	modium moveTo {pos(-1544.48, 292.00, -225.50)}
execute{"/say "+npcEntity.getHealth().toString()}
	modium setTarget{player}
	wait{15.sec}
	modium.clearTarget()
	modium moveTo {pos(-1529.67, 294.19, -187.53)}
execute{"/say "+npcEntity.getHealth().toString()}
	modium setTarget{player}
}}*/


