
use pocketmine\item\Item;
use pocketmine\entity\Entity;
use pocketmine\level\Level;
use pocketmine\level\Position;
use pocketmine\Player;
use pocketmine\Server;
use pocketmine\event\entity\EntityDamageEvent;

class Lava extends Liquid{
	public function __construct($meta = 0){
		parent::__construct(self::LAVA, $meta, "Lava");
		$this->hardness = 0;
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

	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		$ret = $this->getLevel()->setBlock($this, $this, true, false);
		$this->getLevel()->scheduleUpdate($this, $this->tickRate());

		return $ret;
	}

}
