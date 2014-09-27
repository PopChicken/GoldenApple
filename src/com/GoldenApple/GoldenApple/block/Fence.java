

use pocketmine\math\AxisAlignedBB;
use pocketmine\math\Vector3;

class Fence extends Transparent{
	public function __construct(){
		parent::__construct(self::FENCE, 0, "Fence");
		$this->isFullBlock = false;
		$this->hardness = 15;
	}

	public function getBoundingBox(){
		$flag = $this->canConnect($this->getSide(2));
		$flag1 = $this->canConnect($this->getSide(3));
		$flag2 = $this->canConnect($this->getSide(4));
		$flag3 = $this->canConnect($this->getSide(5));

		$f =  $flag2 ? 0 : 0.375;
		$f1 = $flag3 ? 1 : 0.625;
		$f2 = $flag ? 0 : 0.375;
		$f3 = $flag1 ? 1 : 0.625;

		return new AxisAlignedBB(
			$this->x + $f,
			$this->y,
			$this->z + $f2,
			$this->x + $f1,
			$this->y + 1, //TODO: check this, add extra bounding box
			$this->z + $f3
		);
	}

	public function canConnect(Block $block){
		return ($block->getID() !== self::FENCE and $block->getID() !== self::FENCE_GATE) ? $block->isSolid : true;
	}

}