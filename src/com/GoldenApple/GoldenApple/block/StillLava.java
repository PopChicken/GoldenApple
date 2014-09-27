
use pocketmine\event\entity\EntityDamageEvent;
use pocketmine\Server;
use pocketmine\entity\Entity;

class StillLava extends Lava{
	public function __construct($meta = 0){
		parent::__construct(self::STILL_LAVA, $meta, "Still Lava");
		$this->hardness = 500;
	}

	public function getBoundingBox(){
		return null;
	}

	public function onEntityCollide(Entity $entity){
		$entity->setOnFire(15);
		$ev = new EntityDamageEvent($entity, EntityDamageEvent::CAUSE_LAVA, 4);
		Server::getInstance()->getPluginManager()->callEvent($ev);
		if(!$ev->isCancelled()){
			$entity->attack($ev->getFinalDamage(), $ev);
		}
		$entity->attack(4, EntityDamageEvent::CAUSE_LAVA);
	}

}