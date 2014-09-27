
use pocketmine\item\Item;
use pocketmine\level\Level;
use pocketmine\level\Position;
use pocketmine\Player;
use pocketmine\Server;
use pocketmine\entity\Entity;

class Water extends Liquid{
	public function __construct($meta = 0){
		parent::__construct(self::WATER, $meta, "Water");
		$this->hardness = 500;
	}

	public function getBoundingBox(){
		return null;
	}
	
	public function onEntityCollide(Entity $entity){
		$entity->fallDistance = 0;
		$entity->extinguish();
	}

	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		$ret = $this->getLevel()->setBlock($this, $this, true, false);
		$this->getLevel()->scheduleUpdate($this, $this->tickRate());

		return $ret;
	}
}
