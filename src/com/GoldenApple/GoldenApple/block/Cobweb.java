
use pocketmine\item\Item;
use pocketmine\entity\Entity;

class Cobweb extends Flowable{
	public function __construct(){
		parent::__construct(self::COBWEB, 0, "Cobweb");
		$this->isSolid = true;
		$this->isFullBlock = false;
		$this->hardness = 25;
	}

	public function onEntityCollide(Entity $entity){
		$entity->fallDistance = 0;
	}

	public function getDrops(Item $item){
		return [];
	}
}