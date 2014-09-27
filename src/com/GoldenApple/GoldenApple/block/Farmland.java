
use pocketmine\item\Item;
use pocketmine\math\AxisAlignedBB;

class Farmland extends Solid{
	public function __construct($meta = 0){
		parent::__construct(self::FARMLAND, $meta, "Farmland");
		$this->hardness = 3;
	}

	public function getBoundingBox(){
		return new AxisAlignedBB(
			$this->x,
			$this->y,
			$this->z,
			$this->x + 1,
			$this->y + 0.9375,
			$this->z + 1
		);
	}

	public function getDrops(Item $item){
		return [
			[Item::DIRT, 0, 1],
		];
	}
}