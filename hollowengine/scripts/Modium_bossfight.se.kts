//import com.is.data.CommonEnhancedBossEventManager

val players by server.players
val player = players().first()

val modium by NPCEntity.creating {
    name = "Модиум" //Имя персонажа
    model = "is:models/npc/modium.gltf" //Путь к модели персонажа
    attributes = Attributes( //список атрибутов персонажа (здоровье, скорость и т.п.) - всё как в команде /attribute
        "minecraft:generic.max_health" to 350f,
        "minecraft:generic.movement_speed" to 0.4f, //к примеру здоровье
    )
    animations[AnimationType.IDLE] = "modium"
    animations[AnimationType.WALK] = "walk"
    showName = true //показывать ли ник с именем над нпс
    pos = pos(-1531.54, 291.06, -206.78) //координаты где спавнить нпс
    showName = false
}
var modium_is_alive: Boolean = true

var npcEntity = NPCEntity(player.level)
next {
 npcEntity = modium.invoke()!!
}

next{npcEntity.setHealth(350f)}
modium lookAt {player}

execute{"/bind_enhanced_boss_bar @e[name=\"Модиум\",limit=1]"}

//modium moveAlwaysTo {player}


val bit_time: Int = 10

async{
While ({modium_is_alive})
{
If({modium_is_alive})
{
execute{"/say "+npcEntity.getHealth().toString()}
	modium setTarget{player}
	
	var j = 1
	execute{"/say "+modium_is_alive.toString()}
	While({j<=bit_time})
	{
		If({modium_is_alive})
		{
			execute{"/say J="+j.toString()}
			wait{10}
		}.
		Elif({!modium_is_alive})
		{
			modium.clearTarget()
		}
		next{j++}
	}
	next{j=1}
	modium.clearTarget()
	modium moveTo {pos(-1531.54, 291.06, -206.78)}
}
If({modium_is_alive})
{
execute{"/say "+npcEntity.getHealth().toString()}
	modium setTarget{player}
	
	var j = 1
	execute{"/say "+modium_is_alive.toString()}
	While({j<=bit_time})
	{
		If({modium_is_alive})
		{
			execute{"/say J="+j.toString()}
			wait{10}
		}.
		Elif({!modium_is_alive})
		{
			modium.clearTarget()
		}
		next{j++}
	}
	next{j=1}
	modium.clearTarget()
	modium moveTo {pos(-1546.70, 292.00, -194.44)}
}

If({modium_is_alive})
{
execute{"/say "+npcEntity.getHealth().toString()}
	modium setTarget{player}
	
	var j = 1
	execute{"/say "+modium_is_alive.toString()}
	While({j<=bit_time})
	{
		If({modium_is_alive})
		{
			execute{"/say J="+j.toString()}
			wait{10}
		}.
		Elif({!modium_is_alive})
		{
			modium.clearTarget()
		}
		next{j++}
	}
	next{j=1}
	modium.clearTarget()
	modium moveTo {pos(-1514.41, 291.00, -213.36)}
}

If({modium_is_alive})
{
execute{"/say "+npcEntity.getHealth().toString()}
	modium setTarget{player}
	
	var j = 1
	execute{"/say "+modium_is_alive.toString()}
	While({j<=bit_time})
	{
		If({modium_is_alive})
		{
			execute{"/say J="+j.toString()}
			wait{10}
		}.
		Elif({!modium_is_alive})
		{
			modium.clearTarget()
		}
		next{j++}
	}
	next{j=1}
	modium.clearTarget()
	modium moveTo {pos(-1544.48, 292.00, -225.50)}
}

If({modium_is_alive})
{
execute{"/say "+npcEntity.getHealth().toString()}
	modium setTarget{player}
	
	var j = 1
	execute{"/say "+modium_is_alive.toString()}
	While({j<=bit_time})
	{
		If({modium_is_alive})
		{
			execute{"/say J="+j.toString()}
			wait{10}
		}.
		Elif({!modium_is_alive})
		{
			modium.clearTarget()
		}
		next{j++}
	}
	next{j=1}
	modium.clearTarget()
	modium moveTo {pos(-1529.67, 294.19, -187.53)}
execute{"/say "+npcEntity.getHealth().toString()}
	modium setTarget{player}
}	
}}
next{modium_is_alive = true}
While ({modium_is_alive})
{
	var a: Float = npcEntity.getHealth()
	next {a = npcEntity.getHealth()}
	//execute{"/say "+a.toString()}
	If ({a<19f})
	{
		next{modium_is_alive=false}
		modium.clearTarget()
		execute{"/say END"}
	}
}
modium.clearTarget()
modium lookAlwaysAt {player}
modium.invulnerable = true
//next {CommonEnhancedBossEventManager.remove(modium}
modium say{"Ладно, всё, достаточно"}
wait{4.sec}
players say{"Я же просил тебя сдаться. Я не хотел прибегать к такому"}
wait{4.sec}
modium say{"Тебе не понять, малец. Добивай. "}
wait{4.sec}
modium say{"Знай, что мои последователи продолжат мое дело. Все так просто не кончится. "}
wait{6.sec}

var choice_result = true
dialogue {
	choice(ChoiceAction.WORLD){
		players say{"Я убийца?"}
		"Я Добью тебя!"{
			players say{"Убить"}
			choice_result = true
		}
		"Сохранить ему жизнь"{
			players say{"Я сохраню тебе жизнь..."}
			choice_result = false
		}
	}
}
